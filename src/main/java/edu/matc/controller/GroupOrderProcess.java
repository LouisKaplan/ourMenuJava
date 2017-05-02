package edu.matc.controller;

import edu.matc.entity.MenuItems;
import edu.matc.entity.Users;
import edu.matc.entity.UsersMenuItems;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/groupOrderProcess"})
public class GroupOrderProcess extends HttpServlet{

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

        String restaurantNameFromForm = request.getParameter("restaurantNameSelect");
        String[] userNamesFromForm = request.getParameterValues("selectDiners");

        List<Users> userNameList = convertDisplayNamesToUserObjects(userNamesFromForm);
        HashMap<String, List<String>> userOrder = findMenuItemsByUser(userNameList, restaurantNameFromForm);


        session.setAttribute("selectedUsers", userNamesFromForm);
        session.setAttribute("userMap", userOrder);
        session.setAttribute("groupOrderRestaurantName", restaurantNameFromForm);


        String url = "groupOrderProcessDisplay";

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

    public List<MenuItems> findMenuItemsByRestaurant(String restaurantName){
        MenuItemsDao itemsDao = new MenuItemsDao();
        List<MenuItems> itemsList = itemsDao.getMenuItemsByRestaurant(restaurantName);
        return itemsList;
    }

    public List<String> findMenuItemNames (List<MenuItems> menuItemsList){
        MenuItemsDao itemsDao = new MenuItemsDao();
        List<String> listOfMenuItemNames = new ArrayList<String>();

        for(MenuItems menuItem:menuItemsList){
            listOfMenuItemNames.add(menuItem.getItemDescription());
        }
        return listOfMenuItemNames;
    }




    public HashMap<String, List<String>> findMenuItemsByUser(List<Users> userNameList, String restaurantName){
        UsersMenuItemsDao umiDAO = new UsersMenuItemsDao();
        HashMap<String, List<String>> umiMap = new HashMap<String, List<String>>();

        for(Users user:userNameList){
            List<MenuItems> menuItemsByUser = new ArrayList<MenuItems>();
            List<UsersMenuItems> listOfUMI = umiDAO.getUsersMenuItemsByUser(user);
            List<String> menuItemNamesForUser;
            for (UsersMenuItems umi:listOfUMI){

                if (umi.getMenuItemID().getRestaurantName().equals(restaurantName)){
                    menuItemsByUser.add(umi.getMenuItemID());
                }
            }
            menuItemNamesForUser = findMenuItemNames(menuItemsByUser);
            umiMap.put(user.getDisplayName(), menuItemNamesForUser);
        }
        return umiMap;
    }
}