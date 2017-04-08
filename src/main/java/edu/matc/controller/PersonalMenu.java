package edu.matc.controller;

import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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

    /**
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = "personalMenuDisplay";
        UsersMenuItemDao userMenuDao = new UsersMenuItemDao();

        try {

            response.sendRedirect(url);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}