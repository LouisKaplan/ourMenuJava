package edu.matc.controller;

import edu.matc.entity.MenuItems;
import edu.matc.entity.Users;
import edu.matc.entity.UsersMenuItems;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
        log.info("$$$$$$$$$$$SESSION USER: " + userName);

        String[] menuItemsFromForm = request.getParameterValues("menuItem");
        List<MenuItems> foundMenuItems = convertMenuItemNamesToUserObjects(menuItemsFromForm);
        String restaurantName = getRestaurantForItems( foundMenuItems);
        log.info("$$$$$$$$$$$$$$RESTAURANT NAME " + restaurantName);
        if (foundMenuItems.size() > 0){deleteOldOrder(userName, restaurantName);}
        addNewOrder (session, userName, foundMenuItems);

        String url = "personalMenuDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<MenuItems> convertMenuItemNamesToUserObjects(String[] menuItemsFromForm){
        int i = 0;
        List<MenuItems> listOfMenuItems = new ArrayList<MenuItems>();
        MenuItemsDao menuDao = new MenuItemsDao();

        while(i < menuItemsFromForm.length){
            //log.info("$$$$$$$$$MenuItemFromFormExists:" + menuItemsFromForm[i]);
            List<MenuItems> menuItemToAdd = menuDao.getMenuItemsByName(menuItemsFromForm[i]);
            listOfMenuItems.add(menuItemToAdd.get(0));
            i++;
        }
        return listOfMenuItems;
    }

    public String getRestaurantForItems(List<MenuItems> menuItems){
        String restaurantName = menuItems.get(0).getRestaurantName();
        return restaurantName;

    }

    public void deleteOldOrder(String userName, String restaurantName){
        UsersMenuItemsDao umiDao = new UsersMenuItemsDao();
        List<UsersMenuItems> umiList = umiDao.getAllUsersMenuItems();
        int idToDelete = 0;

        for (UsersMenuItems umi : umiList
             ) {
//            log.info("CHECKPOINT LOOP: " + umi.getUserName().getUserName());
//            log.info("CHECKPOINT LOOP 2: "+ umi.getMenuItemID().getRestaurantName());
            if (umi.getUserName().getUserName().equals(userName) &&
                umi.getMenuItemID().getRestaurantName().equals(restaurantName)){

                 idToDelete = umi.getUserItemID();
                 log.info("DELETED: " + userName + " ID: " + idToDelete);
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
        log.info(userName + " added " + menuItemNames.toString());
        session.setAttribute("updateMenuMessage", userName + " changed their order to: " + menuItemNames.toString());


    }
}
