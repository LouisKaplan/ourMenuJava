package edu.matc.controller;

import edu.matc.entity.Users;
import edu.matc.persistence.*;

import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(
        urlPatterns={"/pizzaDenominator"}
)
public class PizzaDenominator extends HttpServlet {
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

        List<String> allUserList = getListOfUsers();
        session.setAttribute("allUserList", allUserList);

        String url = "pizzaDenominatorDisplay";

        try {
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<String> getListOfUsers(){
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = new ArrayList<Users>();
        try {
            usersList = usersDao.getAllUsers();
        } catch (Exception e){
            log.error("Error getting all Users ", e);
        }
        List<String> userNamesList = new ArrayList<String>();

        for (Users user :usersList) {
            userNamesList.add(user.getDisplayName());
        }
        return userNamesList;
    }
}