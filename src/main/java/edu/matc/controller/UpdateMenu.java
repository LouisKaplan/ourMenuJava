package edu.matc.controller;

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
        name="updateMenu",
        urlPatterns={"/updateMenu"}
)
public class UpdateMenu extends HttpServlet {

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

        ServletContext context = getServletContext();

//        EmployeeDirectory employeeDirectory = (EmployeeDirectory) context.getAttribute("employeeDirectory");
        HttpSession session = request.getSession();
        String url = "/java112/updateMenuDisplay";
//
//        try {
//
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String ssn = request.getParameter("ssn");
//            String department = request.getParameter("department");
//            String roomNumber = request.getParameter("roomNumber");
//            String phoneNumber = request.getParameter("phoneNumber");
//
//            employeeDirectory.addNewRecord(firstName, lastName, ssn, department, roomNumber, phoneNumber);
//
//            session.setAttribute("project4AddMessage", "Employee Added Successfully");
//
//            response.sendRedirect(url);
//
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }

    }
}