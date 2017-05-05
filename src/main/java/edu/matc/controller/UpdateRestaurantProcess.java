package edu.matc.controller;

import edu.matc.entity.MenuItems;
import edu.matc.entity.Restaurants;
import edu.matc.entity.Users;
import edu.matc.entity.UsersMenuItems;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.awt.*;
import java.io.*;
import java.lang.String;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/updateRestaurantProcess"})

public class UpdateRestaurantProcess extends HttpServlet {
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

        String restaurantName = request.getParameter("restaurantName");
        String[] itemsToDelete = request.getParameterValues("deleteMenuItem");
        String[] itemsToAdd = request.getParameterValues("newMenuItem");
        String[] newItemCategories = request.getParameterValues("newItemCategory");

        List<MenuItems> itemObjectsToDelete = convertMenuItemNamesToMenuItemObjects(itemsToDelete, restaurantName);




        if (itemsToAdd.length > 0){
            addNewMenuItems(restaurantName, itemsToAdd, newItemCategories);
        }

        String url = "updateMenuDisplay";
        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<MenuItems> convertMenuItemNamesToMenuItemObjects(String[] itemsToDelete, String restaurantName){
        List<MenuItems> listOfMenuItems = new ArrayList<MenuItems>();
        MenuItemsDao menuDao = new MenuItemsDao();

        int i = 0;
        while(i < itemsToDelete.length){
            List<MenuItems> itemBeingDeleted = menuDao.getMenuItemsByName(itemsToDelete[i]);
            if(itemBeingDeleted.get(0).getRestaurantName().equals(restaurantName)) {
                listOfMenuItems.add(itemBeingDeleted.get(0));
            }i++;
        }
        return listOfMenuItems;
    }




    public void addNewMenuItems(String restaurantName, String[] itemsToAdd, String[] newItemCategories){
        int i = 0;
        MenuItemsDao itemDao = new MenuItemsDao();
        while(i < itemsToAdd.length){
            MenuItems newMenuItem = new MenuItems(restaurantName, itemsToAdd[i], newItemCategories[i]);
            itemDao.addMenuItem(newMenuItem);
        }
    }

















}