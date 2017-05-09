package edu.matc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.entity.*;
import edu.matc.googleMaps.GetCoordinates;
import edu.matc.googleMaps.Results;
import edu.matc.googleMaps.ResultsItem;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

import static java.lang.Double.NaN;

@WebServlet(
        urlPatterns={"/restaurantSelectorProcess"})
public class RestaurantSelectorProcess extends HttpServlet{
    private final Logger log = Logger.getLogger(this.getClass());
    String restaurant;
    String city;
    String state;
    double lat;
    double lon;
    /**
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);

        String[] userNamesFromForm = request.getParameterValues("selectDiners");
        this.city = request.getParameter("selectCity");
        this.city = city.replaceAll(" ", "_").toLowerCase();
        this.state = request.getParameter("selectState");
        this.state = state.replaceAll(" ", "_").toLowerCase();
        List<Users> usersList = convertDisplayNamesToUserObjects(userNamesFromForm);
        List<String> userNamesList = getUserNamesFromUserList(usersList);
        HashMap<String, Double> ratingMap = getRestaurantRatingMap(userNamesList);
        HashMap<String, Double> sortedMap = sortHashMap(ratingMap);
        Results mapResults = getJSON(restaurant, city, state);
        getMapCoordinates(mapResults);
        session.setAttribute("mapLat", lat);
        session.setAttribute("mapLon", lon);

        session.setAttribute("sortedMap", sortedMap);

        String url = "restaurantSelectorResultDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<Users> convertDisplayNamesToUserObjects(String[] userList){
        int i = 0;
        List<Users> listOfSelectedUsers = new ArrayList<Users>();
        UsersDao userDao = new UsersDao();
        while(i < userList.length){
            List<Users> userToAdd = userDao.getUserByDisplayName(userList[i]);
            listOfSelectedUsers.add(userToAdd.get(0));
            i++;
        }
        return listOfSelectedUsers;
    }

    public List<String> getUserNamesFromUserList(List<Users> userList){
        List<String> listOfUserNames = new ArrayList<String>();
        for (Users user: userList
             ) {listOfUserNames.add(user.getUserName());
        }
        return listOfUserNames;
    }

    public List<Restaurants> getAllRestaurantsFromDB(){
        RestaurantsDao restDao = new RestaurantsDao();
        List<Restaurants> restaurantList = restDao.getAllRestaurants();
        return restaurantList;
    }

    public Double findAverage(Double ratingCount, int incrementCount){
        Double averageRating = (ratingCount / incrementCount);
        return averageRating;
    }

    public HashMap<String, Double> getRestaurantRatingMap(List<String> userNameList) {
        UsersRestaurantsDao userRestDao = new UsersRestaurantsDao();
        List<UsersRestaurants> userRestList = userRestDao.getAllUsersRestaurants();
        List<Restaurants> restaurantList = getAllRestaurantsFromDB();
        HashMap<String, Double> mapOfRestaurantRatings = new HashMap<String, Double>();
        DecimalFormat df = new DecimalFormat("#.#");
        Double ratingCount = 0.00;
        int incrementCount = 0;

        for (Restaurants restaurant : restaurantList) {
            ratingCount = 0.00;
            incrementCount = 0;
            for (UsersRestaurants ur : userRestList
                    ) {
                if (userNameList.contains(ur.getUsers().getUserName())
                        && (restaurant.getRestaurantName().equals(ur.getRestaurants().getRestaurantName()) )) {
                    ratingCount += ur.getUserRating();
                    incrementCount ++;

                }
            }
            Double averageRating = findAverage(ratingCount, incrementCount);

            if (averageRating > 0) {
                mapOfRestaurantRatings.put(restaurant.getRestaurantName(), averageRating);
            }
        }
        return mapOfRestaurantRatings;
    }

    public LinkedHashMap<String, Double> sortHashMap(HashMap<String, Double> map){
        List<String> mapKeys = new ArrayList<String>(map.keySet());
        List<Double> mapValues = new ArrayList<Double>(map.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        int mapLength = mapKeys.size();
        mapLength --;
        this.restaurant = mapKeys.get(mapLength);
        this.restaurant = restaurant.replaceAll(" ", "_").toLowerCase();


        LinkedHashMap<String, Double> sortedMap =
                new LinkedHashMap<String, Double>();

        Iterator<Double> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Double val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Double comp1 = map.get(key);
                Double comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;

    }

    public Results getJSON(String restaurant, String city, String state){
        GetCoordinates coordinatesCall = new GetCoordinates();
        Results callResults = null;
        try {
            callResults = coordinatesCall.MakeCall(restaurant, city, state);
        } catch (JsonProcessingException e) {
            log.error("problem with JSON when making call to Maps service");
        } catch (Exception e) {
            // 502 Bad Gateway
            log.error("problem making call to Maps service");
        }
        return callResults;

    }

    public void getMapCoordinates(Results callResults){
        List<ResultsItem> resultsList = callResults.getResults();
        ResultsItem resultsItem = resultsList.get(0);
        this.lat = resultsItem.getGeometry().getLocation().getLat();
        this.lon = resultsItem.getGeometry().getLocation().getLng();

    }
}
