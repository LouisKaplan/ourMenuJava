package edu.matc.entity;

import edu.matc.entity.Users;
import edu.matc.persistence.UsersDao;
import org.apache.log4j.Logger;

/**
 * Created by student on 4/28/17.
 */
public class NewUserObject {

    private final Logger log = Logger.getLogger(this.getClass());

    private String password;
    private String confirmPassword;
    private String userName;
    private String displayName;
    private String message;

    public NewUserObject(){
    }

    public NewUserObject(String password, String confirmPassword, String userName, String displayName) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.userName = userName;
        this.displayName = displayName;
    }

    public boolean isEverythingValid(){
        if (isUserNameValid() && isDisplayNameValid() && isPwValid()){
            return true;
        } else {
            return false;
        }
    }

    public boolean isUserNameValid() {
        boolean valid = true;
        UsersDao usersDao = new UsersDao();
        Users existingUser = null;

        try{
            existingUser = usersDao.getUser(userName);
        } catch (Exception e){
            log.error("getUserName error", e);
        }

        if (existingUser != null) {
            valid = false;
            message = "Entered userName is taken";
        } else if (userName.isEmpty()) {
            message = "Please enter a display name";
            valid = false;
        } else if (userName.length() < 5) {
            message = "Display Name must be five characters or longer.";
            valid = false;
        } else if (!userName.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Please enter a display name without special characters";
            valid = false;
        }
        return valid;
    }

    public boolean isDisplayNameValid() {
        boolean valid = true;
        if (displayName.isEmpty()) {
            message = "Please enter a display name";
            valid = false;
        } else if (displayName.length() < 5) {
            message = "Display Name must be five characters or longer.";
            valid = false;
        } else if (!displayName.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Please enter a display name without special characters";
            valid = false;
        }
        return valid;
    }

    public boolean isPwValid() {
        boolean valid = true;
        if (password.isEmpty()) {
            message = "Please enter a password";
            valid = false;
        } else if (password.length() < 5) {
            message = "Password must be five characters or longer.";
            valid = false;
        } else if (!password.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Please enter a password without special characters";
            valid = false;
        }else if (!password.equals(confirmPassword)) {
            message = "Password does not match re-typed password";
            valid = false;
        }
        return valid;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}