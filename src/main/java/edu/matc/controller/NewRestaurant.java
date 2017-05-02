package edu.matc.controller;

import edu.matc.entity.MenuItems;
import edu.matc.entity.Restaurants;
import edu.matc.entity.Users;
import edu.matc.entity.UsersMenuItems;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/newRestaurant"})
public class NewRestaurant extends HttpServlet {
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


        String restaurantName = request.getParameter("newRestaurantName");
        String restaurantCategory = request.getParameter("newRestaurantCategory");
        HashMap<String, String> menuItemsMap = getMenuItemsParameters(request);
        addRestaurantToDatabase(restaurantName, restaurantCategory, session);
        createNewMenuItem(menuItemsMap, restaurantName, session);


        String url = "newRestaurantDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public HashMap<String, String> getMenuItemsParameters(HttpServletRequest request){
        int i = 1;
        HashMap<String, String> menuItemsAndCategories = new HashMap<String, String>();
        while (i < 25){
            menuItemsAndCategories.put(request.getParameter("newMenuItem" + i), request.getParameter("newItemCategory" + i));
            i++;
        }
        log.info(menuItemsAndCategories);
        return menuItemsAndCategories;
    }

    public void addRestaurantToDatabase(String restaurantName, String restaurantCategory, HttpSession session){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        Restaurants newRestaurant = new Restaurants();
        newRestaurant.setRestaurantName(restaurantName);
        newRestaurant.setRestaurantType(restaurantCategory);
        restaurantsDao.addRestaurant(newRestaurant);

        session.setAttribute("newRestaurantSuccessMessage", "New Restaurant Added");
    }

    public void createNewMenuItem(HashMap<String, String> map, String restaurantName, HttpSession session){
        for(Map.Entry<String, String> entry : map.entrySet()){
            String item = entry.getKey();
            String category = entry.getValue();
            if (item != "" && category != "");
            MenuItems newMenuItem = new MenuItems();
            newMenuItem.setRestaurantName(restaurantName);
            newMenuItem.setItemDescription(item);
            newMenuItem.setItemType(category);
            addMenuItemToDatabase(newMenuItem, session);
        }
    }

    public void addMenuItemToDatabase(MenuItems newItem, HttpSession session){
        MenuItemsDao menuItemsDao = new MenuItemsDao();
        menuItemsDao.addMenuItem(newItem);
        session.setAttribute("newMenuItemsSuccessMessage", "MenuItems Added");
    }

}