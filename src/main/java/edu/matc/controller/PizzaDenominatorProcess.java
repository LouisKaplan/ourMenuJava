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

        List<List<String>> userPizzaList = findPizzaPreferencesByUser(userNameList);
        List<String> finalPizzaList = denominate(userPizzaList);

        session.setAttribute("finalPizzaList", finalPizzaList);
        session.setAttribute("pizzaDenominatorMessage", "A pizza that will make everyone happy:");

        String url = "pizzaDenominatorDisplay";

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

    public List<String> findMenuItemNames (List<MenuItems> menuItemsList){
        List<String> listOfMenuItemNames = new ArrayList<String>();

        for(MenuItems menuItem:menuItemsList){
            listOfMenuItemNames.add(menuItem.getItemDescription());
        }
        return listOfMenuItemNames;
    }

    public List<List<String>> findPizzaPreferencesByUser(List<Users> userNameList){
        UsersMenuItemsDao umiDAO = new UsersMenuItemsDao();
        List<List<String>> umiList = new ArrayList<List<String>>();

        for(Users user:userNameList){
            List<MenuItems> menuItemsByUser = new ArrayList<MenuItems>();
            List<UsersMenuItems> listOfUMI = umiDAO.getUsersMenuItemsByUser(user);
            List<String> menuItemNamesForUser;
            for (UsersMenuItems umi:listOfUMI){

                if (umi.getMenuItemID().getRestaurantName().equals("Pizza")){
                    menuItemsByUser.add(umi.getMenuItemID());
                }
            }
            menuItemNamesForUser = findMenuItemNames(menuItemsByUser);
            umiList.add(menuItemNamesForUser);
        }
        return umiList;
    }

    public List<String> denominate(List<List<String>> userPizzaList) {
        List<String> comparisonList = userPizzaList.get(0);
        List<String> toBeRemoved = new ArrayList<String>();
        for (String compareString : comparisonList) {
            for (List<String> loopList : userPizzaList) {
                if (loopList.contains(compareString) == false) {
                    toBeRemoved.add(compareString);
                    break;
                }
            }
        }
        for (String removeWord : toBeRemoved
             ) {comparisonList.remove(removeWord);

        } return comparisonList;
    }
}
