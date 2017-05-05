package edu.matc.controller;

import edu.matc.entity.Users;
import edu.matc.persistence.UsersDao;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(
        urlPatterns = { "/addLoginToSession" }
)

public class AddLoginToSession  extends HttpServlet {
    private UsersDao dao = new UsersDao();
    private boolean checksOut = true;
    private final Logger log = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userName = request.getParameter("j_username");
        String userPassword = request.getParameter("j_password");
        Users user = dao.getUser(userName);

        session.setAttribute("user", userName);
        String checkUserName = session.getAttribute("user").toString();

        if (user == null){
            checksOut = false;
        } else {
            checkCredentials(userPassword, user);
        }
        if(checksOut){
            session.setAttribute("failure", null);
            String url = "j_security_check?j_username=" + userName + "&j_password=" + userPassword;
            String redirectURL = response.encodeRedirectURL(url);
            response.sendRedirect(redirectURL);
            session.setAttribute("user", userName);
        } else {
        response.sendRedirect("/index.jsp");
    }

    }

    private void checkCredentials(String userPassword, Users user) {
        if(!user.getUserPassword().equals(userPassword)){
            checksOut = false;
        }
    }
}