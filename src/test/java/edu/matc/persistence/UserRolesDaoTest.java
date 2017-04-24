package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserRolesDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    UserRolesDao dao;
    UserRoles testUserRole;
    String testUserName = "xxx";

    @Before
    public void setup() {
        dao = new UserRolesDao();
        testUserRole = new UserRoles();

        testUserRole.setUserName("TestUser");
        testUserRole.setUserRole("Ghost");
    }

    @After
    public void cleanup(){
        if (testUserName != "xxx") {
            dao.deleteUserRole(testUserName);
        }
    }

    @Test
    public void getAllUserRoles() throws Exception {
        List<UserRoles> userRoles = dao.getAllUserRoles();
        assertTrue(userRoles.size() > 0);
        log.info("all users: " + userRoles);
    }

    @Test
    public void getUserRole() throws Exception {
        testUserName = dao.addUserRole(testUserRole);
        UserRoles findUserRole = dao.getUserRole(testUserName);
        assertTrue("Did not find correct restaurant", findUserRole.getUserRole().equals("Ghost"));

        log.info("UserRole by name: " + findUserRole.getUserName());
    }

    @Test
    public void addUserRole() throws Exception {
        testUserName = dao.addUserRole(testUserRole);
        assertEquals("User Name Not Added", testUserRole.getUserName(),
                                                    dao.getUserRole(testUserName).getUserName());
        assertEquals("User Role Not Added", testUserRole.getUserRole(),
                                                    dao.getUserRole(testUserName).getUserRole());
    }

    @Test
    public void updateUserRole() throws Exception {
        testUserName = dao.addUserRole(testUserRole);

        testUserRole.setUserRole("UserRoleProgress");

        dao.updateUserRole(testUserRole);
        assertEquals("Restaurant Type Not Updated", testUserRole.getUserRole(), dao.getUserRole(testUserName).getUserRole());
    }

    @Test
    public void deleteUserRole() throws Exception {
        dao.addUserRole(testUserRole);
        dao.deleteUserRole(testUserRole.getUserName());
        assertNull("user was still found", dao.getUserRole(testUserRole.getUserName()));
    }
}
