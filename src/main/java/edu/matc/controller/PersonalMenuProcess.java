package edu.matc.controller;

import edu.matc.entity.*;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/personalMenuProcess"})
public class PersonalMenuProcess extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);

        String userName = (String) session.getAttribute("user");

        String[] menuItemsFromForm = request.getParameterValues("menuItem");
        String restaurantName = request.getParameter("restaurantName");

        List<MenuItems> foundMenuItems = convertMenuItemNamesToMenuItemObjects(menuItemsFromForm, restaurantName);


        if (foundMenuItems.size() > 0){deleteOldOrder(userName, restaurantName);}
        addNewOrder (session, userName, foundMenuItems);

        String restaurantRating = request.getParameter("restaurantRating");
        int finalRestaurantRating = findRealRating(restaurantRating);
        if (finalRestaurantRating != 0){updateUserRestaurantRating(userName, restaurantName, finalRestaurantRating);}


        String url = "personalMenuDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<MenuItems> convertMenuItemNamesToMenuItemObjects(String[] menuItemsFromForm, String restaurantName){
        int i = 0;
        List<MenuItems> listOfMenuItems = new ArrayList<MenuItems>();
        MenuItemsDao menuDao = new MenuItemsDao();

        while(i < menuItemsFromForm.length){
            List<MenuItems> menuItemToAdd = menuDao.getMenuItemsByName(menuItemsFromForm[i]);
            if(menuItemToAdd.get(0).getRestaurantName().equals(restaurantName)) {
                listOfMenuItems.add(menuItemToAdd.get(0));
            }i++;
        }
        return listOfMenuItems;
    }

    public void deleteOldOrder(String userName, String restaurantName){
        UsersMenuItemsDao umiDao = new UsersMenuItemsDao();
        List<UsersMenuItems> umiList = umiDao.getAllUsersMenuItems();
        int idToDelete = 0;

        for (UsersMenuItems umi : umiList
             ) {
            if (umi.getUserName().getUserName().equals(userName) &&
                umi.getMenuItemID().getRestaurantName().equals(restaurantName)){

                 idToDelete = umi.getUserItemID();
                 umiDao.deleteUserMenuItem(idToDelete);
            }
        }
    }

    public void addNewOrder (HttpSession session, String userName, List<MenuItems> menuItems){
        UsersMenuItemsDao umiDao = new UsersMenuItemsDao();
        UsersDao userDao = new UsersDao();
        List<String> menuItemNames = new ArrayList<>();
        for (MenuItems menuItem : menuItems
             ) {UsersMenuItems umi = new UsersMenuItems();
             umi.setMenuItemID(menuItem);
             umi.setUserName(userDao.getUser(userName));
             umiDao.addUserMenuItem(umi);
             menuItemNames.add(umi.getMenuItemID().getItemDescription());
        }
        session.setAttribute("updateMenuMessage", userName + " changed their order to: " + menuItemNames.toString());
    }

    public int findRealRating(String ratingAnswer){
        int realRating;
        if(ratingAnswer != "none"){
            realRating = Integer.parseInt(ratingAnswer);
        } else {
            realRating = 0;
        } return realRating;
    }

    public void updateUserRestaurantRating(String userName, String restaurantName, int finalRestaurantRating){
        UsersDao userDao = new UsersDao();
        RestaurantsDao restDao = new RestaurantsDao();
        UsersRestaurantsDao urDAO = new UsersRestaurantsDao();

        UsersRestaurants newUR = new UsersRestaurants();

        Users userObject = userDao.getUser(userName);
        newUR.setUsers(userObject);

        Restaurants restObject = restDao.getRestaurant(restaurantName);
        newUR.setRestaurants(restObject);

        newUR.setUserRating(finalRestaurantRating);

        List<UsersRestaurants> urList = urDAO.getAllUsersRestaurants();
        boolean urFound = false;

        for (UsersRestaurants urLoop : urList
             ) {if(urLoop.getUsers().getUserName().equals(userName) &&
                    urLoop.getRestaurants().getRestaurantName().equals(restaurantName)
                    && !urFound){
                        urLoop.setUserRating(finalRestaurantRating);
                        urDAO.updateUsersRestaurants(urLoop);
                        urFound = true;
                    }
            }
        if(urFound == false){
            urDAO.addUsersRestaurants(newUR);
        }
    }
}
