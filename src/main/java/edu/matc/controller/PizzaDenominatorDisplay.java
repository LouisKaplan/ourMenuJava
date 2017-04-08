package edu.matc.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.lang.*;

/**
 * This is a display servlet that does
 * nothing but forward to a corresponding JSP.
 * @author Louis Kaplan
 * @version 1.0
 */
@WebServlet(
        name = "pizzaDenominatorDisplay",
        urlPatterns = { "/pizzaDenominatorDisplay" }
)

public class PizzaDenominatorDisplay extends HttpServlet {

    /**
     *  doGet forwards to a corresponding JSP
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/pizzaDenominator.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}