package edu.matc.persistence;

import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    UsersDao dao;
    Users testUser;
    String testUserName = "xxx";

    @Before
    public void setup() {
        dao = new UsersDao();
        testUser = new Users();

        testUser.setUserName("DaoTest");
        testUser.setDisplayName("Test Testerson");
        testUser.setUserPassword("TestPassword");
    }

    @After
    public void cleanup(){
        if (testUserName != "xxx") {
            dao.deleteUser(testUserName);
        }
    }

    @Test
    public void getAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
        log.info("all users: " + users);
    }

    @Test
    public void getUser() throws Exception {
        testUserName = dao.addUser(testUser);
        Users findUser = dao.getUser(testUserName);
        assertTrue("Did not find correct display name", findUser.getDisplayName().equals("Test Testerson"));
        log.info("user display name found by userName: " + findUser.getDisplayName());
    }
//
//    @Test
//    public void addUser() throws Exception {
//        newUserTestCase = dao.addUser(testUser);
//        assertEquals("actor first name not added", testUser.getFirstName(), dao.getUser(newUserTestCase).getFirstName());
//        assertEquals("actor last name not added", testUser.getLastName(), dao.getUser(newUserTestCase).getLastName());
//    }
//
//    @Test
//    public void updateUser() throws Exception {
//        newUserTestCase = dao.addUser(testUser);
//
//        testUser.setFirstName("FirstInProgress");
//        testUser.setLastName("LastInProgress");
//
//        dao.updateUser(testUser);
//        assertEquals("actor first name not updated", testUser.getFirstName(), dao.getUser(newUserTestCase).getFirstName());
//        assertEquals("actor last name not updated", testUser.getLastName(), dao.getUser(newUserTestCase).getLastName());
//    }
//
//    @Test
//    public void deleteUser() throws Exception {
//        dao.addUser(testUser);
//        dao.deleteUser(testUser.getUserid());
//        assertNull("user was still found", dao.getUser(testUser.getUserid()));
//    }

}