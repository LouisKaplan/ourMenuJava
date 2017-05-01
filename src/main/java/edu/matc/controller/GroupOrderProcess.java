package edu.matc.controller;

import edu.matc.entity.Restaurants;
import edu.matc.entity.Users;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/groupOrderProcess"}
)
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


        String restaurantName = request.getParameter("restaurantNameSelect");
        String[] userList = request.getParameterValues("selectDiners");


        convertDisplayNamesToUserNames(userList);


        String url = "groupOrderProcessDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void convertDisplayNamesToUserNames(String[] userList){
        int i = 0;
        UsersDao userDao = new UsersDao();

        while(i <userList.length){


        }


    }


}