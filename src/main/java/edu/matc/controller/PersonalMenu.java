package edu.matc.controller;

import edu.matc.entity.MenuItems;
import edu.matc.entity.Restaurants;
import edu.matc.persistence.MenuItemsDao;
import edu.matc.persistence.RestaurantsDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This servlet is the main controller class for the process of adding an employee.
 * @author Louis Kaplan
 * @version 1.0
 */

@WebServlet(
        name="personalMenu",
        urlPatterns={"/personalMenu"}
)
public class PersonalMenu extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    /**
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        log.info((String) session.getAttribute("user"));
        String userName = (String) session.getAttribute("user");
        log.info("#########PERSONAL MENU SESSION USER: " + userName);
        RestaurantsDao restDao = new RestaurantsDao();
        List<Restaurants> restList = restDao.getAllRestaurants();

        HashMap<String, List<String>> restMenuMap = buildRestaurantArray(restList);
        session.setAttribute("restMenuMap", restMenuMap);

        String url = "personalMenuDisplay";
        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<String> findMenuItemNames (List<MenuItems> menuItemsList){
        List<String> listOfMenuItemNames = new ArrayList<String>();

        for(MenuItems menuItem:menuItemsList){
            listOfMenuItemNames.add(menuItem.getItemDescription());
        }
        return listOfMenuItemNames;
    }


    public HashMap<String, List<String>> buildRestaurantArray (List<Restaurants> restList){
        MenuItemsDao menuDao = new MenuItemsDao();
        HashMap<String, List<String>> restItemMap = new HashMap<String, List<String>>();
        String restName = "";

        for (Restaurants rest: restList) {
            List<MenuItems> menuItemsByRest = new ArrayList<>();
            restName = rest.getRestaurantName();
            menuItemsByRest = menuDao.getMenuItemsByRestaurant(restName);
            List<String> menuItemNames = findMenuItemNames(menuItemsByRest);
            if (menuItemNames.size() >= 2) {
                restItemMap.put(restName, menuItemNames);
            }
        }
            return restItemMap;
    }
}