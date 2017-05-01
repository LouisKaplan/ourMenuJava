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

/**
 * This servlet is the main controller class for the process of adding an employee.
 * @author Louis Kaplan
 * @version 1.0
 */

@WebServlet(
        name="groupOrder",
        urlPatterns={"/groupOrder"}
)
public class GroupOrder { /**
 *  doPost uses the information from the JSP submission form to update the SQL database.
 *  This method gets the EmployeeDirectory from the servlet context and then instantiates the session.
 *  It uses a request to pull data from the employee add form, which it then assigns to variables.
 *  After that, it calls the method in EmployeeDirectory that does the work of adding the information
 *      from those variables to the database.
 *  Finally, it updates a message, which will be passed to the JSP to confirm that the information has been added.
 *
 *
 *@param  request                   the HttpServletRequest object
 *@param  response                   the HttpServletResponse object
 *@exception  ServletException  if there is a Servlet failure
 *@exception  IOException       if there is an IO failure
 */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = "groupOrderDisplay";






        try {
    
            response.sendRedirect(url);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public List<String> getListOfUsers(){
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.getAllUsers();
        List<String> userNamesList = new ArrayList<String>();

        for (Users user :usersList) {
            userNamesList.add(user.getDisplayName());
        }
        return userNamesList;
    }

    public List<String> getListOfUsers(){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        List<Restaurants> restaurantsList = restaurantsDao.getAllRestaurants();
        List<String> restaurantNamesList = new ArrayList<String>();

        for (Users user :usersList) {
            userNamesList.add(user.getDisplayName());
        }
        return userNamesList;
    }

}

