package edu.matc.controller;

import edu.matc.entity.Restaurants;
import edu.matc.entity.Users;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/groupOrder"}
)
public class GroupOrder extends HttpServlet{

    private final Logger log = Logger.getLogger(this.getClass());
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

        List<String> allUserList = getListOfUsers();
        List<String> allRestaurantList = getListOfRestaurants();

        session.setAttribute("SessionWorks", "Session does work");
        session.setAttribute("allRestaurantList", allRestaurantList);
        session.setAttribute("allUserList", allUserList);

        String url = "groupOrderDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public List<String> getListOfUsers(){
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = new ArrayList<Users>();

        try {
             usersList = usersDao.getAllUsers();
        } catch (Exception e){
            log.error("Error getting all Users ", e);
        }

        List<String> userNamesList = new ArrayList<String>();

        for (Users user :usersList) {
            userNamesList.add(user.getDisplayName());
        }
        return userNamesList;
    }

    public List<String> getListOfRestaurants(){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        List<Restaurants> restaurantList = new ArrayList<Restaurants>();

        try {
            restaurantList = restaurantsDao.getAllRestaurants();
        } catch (Exception e){
            log.error("Error getting all Restaurants ", e);
        }

        List<String> restaurantNamesList = new ArrayList<String>();

        for (Restaurants restaurant :restaurantList) {
            restaurantNamesList.add(restaurant.getRestaurantName());
        }
        return restaurantNamesList;
    }
}