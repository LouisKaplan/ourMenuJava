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
        urlPatterns={"/pizzaDenominatorProcess"})
public class PizzaDenominatorProcess extends HttpServlet{
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

        String[] userNamesFromForm = request.getParameterValues("selectDiners");
        List<Users> userNameList = convertDisplayNamesToUserObjects(userNamesFromForm);
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

    public List<String> findMenuItemNames (List<MenuItems> menuItemsList){
        MenuItemsDao itemsDao = new MenuItemsDao();
        List<String> listOfMenuItemNames = new ArrayList<String>();

        for(MenuItems menuItem:menuItemsList){
            listOfMenuItemNames.add(menuItem.getItemDescription());
        }
        return listOfMenuItemNames;
    }

}
