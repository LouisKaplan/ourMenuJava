package edu.matc.controller;

import edu.matc.entity.MenuItems;
import edu.matc.entity.UsersMenuItems;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
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
        String[] itemsToDelete = new String[]{};

        if(request.getParameterValues("deleteMenuItem") != null){
            itemsToDelete = request.getParameterValues("deleteMenuItem");
        }
        String[] itemsToAdd = request.getParameterValues("newMenuItem");
        String[] newItemCategories = request.getParameterValues("newItemCategory");

        if (itemsToDelete.length > 0) {
            List<MenuItems> itemObjectsToDelete = convertMenuItemNamesToMenuItemObjects(itemsToDelete, restaurantName);
            log.info("itemObjectsToDelete" + itemObjectsToDelete.get(0));
            deleteUsersMenuItemsLink(itemObjectsToDelete);
            deleteMenuItems(itemObjectsToDelete);
        }

        if (itemsToAdd.length > 0){
            addNewMenuItems(restaurantName, itemsToAdd, newItemCategories);
        }

        String updateMessage = "Menu updated - see changes below";
        session.setAttribute("updateRestaurantMessage", updateMessage);

        String url = "updateRestaurant";

        log.info("CHECKPOINT: " + url);
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
            List<MenuItems> itemsBeingDeleted = menuDao.getMenuItemsByName(itemsToDelete[i]);
            for (MenuItems deleteItem : itemsBeingDeleted) {
                if(deleteItem.getRestaurantName().equals(restaurantName)) {
                    listOfMenuItems.add(deleteItem);
                }
            }i++;
        }
        return listOfMenuItems;
    }


    public void addNewMenuItems(String restaurantName, String[] itemsToAdd, String[] newItemCategories) {
        int i = 0;
        MenuItemsDao itemDao = new MenuItemsDao();
        while (i < itemsToAdd.length) {
            if (itemsToAdd[i] != "") {
                MenuItems newMenuItem = new MenuItems(restaurantName, itemsToAdd[i], newItemCategories[i]);
                itemDao.addMenuItem(newMenuItem);

            }i++;
        }
    }

    public void deleteUsersMenuItemsLink(List<MenuItems> itemObjectsToDelete){
        UsersMenuItemsDao umiDao = new UsersMenuItemsDao();
        List<UsersMenuItems> umiList = umiDao.getAllUsersMenuItems();

        List<Integer> itemIdList = getItemIDs(itemObjectsToDelete);

        for (Integer itemId: itemIdList) {
            for (UsersMenuItems umi : umiList) {
                if (umi.getMenuItemID().getMenuItemID() == itemId){
                     umiDao.deleteUserMenuItem(umi.getUserItemID());
                }
            }
        }
    }

    public void deleteMenuItems(List<MenuItems> itemObjectsToDelete){
        MenuItemsDao itemsDao = new MenuItemsDao();

        for (MenuItems item : itemObjectsToDelete
             ) {itemsDao.deleteMenuItem(item.getMenuItemID());
        }
    }

    public List<Integer> getItemIDs(List<MenuItems> itemObjectsToDelete){
        List<Integer> itemIDs = new ArrayList<Integer>();
        for (MenuItems item: itemObjectsToDelete
             ) {itemIDs.add(item.getMenuItemID());

        }return itemIDs;
    }
}