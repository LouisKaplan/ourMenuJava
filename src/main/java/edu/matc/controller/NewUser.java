package edu.matc.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import edu.matc.entity.NewUserObject;
import edu.matc.entity.UserRoles;
import edu.matc.entity.Users;
import edu.matc.persistence.UsersDao;
import edu.matc.persistence.UserRolesDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/newUser"}
)
/**
 * Created by student on 4/28/17.
 */
public class NewUser extends HttpServlet{

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = req.getSession(true);
        NewUserObject newUser;

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String userName = req.getParameter("userName");
        String displayName = req.getParameter("displayName");

        log.info("NEW USER CHECKPOINT A " + password + confirmPassword + userName + displayName);
        newUser = new NewUserObject(password, confirmPassword, userName,
                displayName);

        /*
         If new user passed all edits
            logged the user
            set session variables
            and forward to the collection webpage
         else forward to New User form again
         */
        if (newUser.isEverythingValid()) {
            log.info("NEW USER CHECKPOINT B ");
            Users user = addUser(userName, displayName, password);
            loginUser(req, userName, password);
            session.setAttribute("user", user.getUserName());
            session.setAttribute("isLoggedIn",true);
            dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } else { //redo entering new user info forms
            req.setAttribute("errorMessage",newUser.getMessage());
            dispatcher = req.getRequestDispatcher("newUser.jsp");
            dispatcher.forward(req, resp);
        }

    }

    private void loginUser(HttpServletRequest request, String userName, String
            password) {

        try {
            log.info("!!!!!!!!!!!!!!!!!USER LOGIN CHECKPOINT");
            request.login(userName, password);

        } catch (ServletException e) {
            log.error("!!!!!!!!!!!!!!!!!FAILED TO LOGIN AFTER ADDING", e);
        }

    }

    /**
     * This method adds the user
     */
    private Users addUser(String userName, String displayName, String
            password) {
        log.info("NEW USER CHECKPOINT D ");
        Users user = new Users(userName,displayName,password);
        UserRoles userRole = new UserRoles(userName, "user");
        UsersDao userDao = new UsersDao();
        UserRolesDao roleDao = new UserRolesDao();

        try {
            log.info("NEW USER CHECKPOINT E ");
            userDao.addUser(user);
            roleDao.addUserRole(userRole);
        } catch (Exception exception) {
            log.error("Unable to add user ", exception);
        }
        log.info("NEW USER CHECKPOINT F ");
        return user;
    }


}
