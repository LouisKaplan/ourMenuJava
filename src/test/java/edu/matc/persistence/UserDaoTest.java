package edu.matc.persistence;

import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 9/13/16.
 *
 * @author pwaite
 */
public class UserDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    UsersDao dao;

    @Before
    public void setup() {
        dao = new UsersDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
        log.info("all users: " + users);
    }


    @Test
    public void getUser() throws Exception {
        Users testUser = dao.getUser(1);
        assertTrue("Did not find correct last name", testUser.getLastName().equals("TestLast"));
        log.info("user by ID: " + testUser.getLastName());

    }

/*
    @Test
    public void addUser() throws Exception {
        User testUser = new User();
        testUser.setFirstName("DaoFirst");
        testUser.setLastName("DaoLast");
        LocalDate daoDate = LocalDate.parse("1986-08-15");
        testUser.setDateOfBirth(daoDate);
        int userId = dao.addUser(testUser);
        assertTrue("name match not found", dao.getUser(userId).getLastName().equals("DaoLast"));
    }

    @Test
    public void updateUser() throws Exception {

        User testUser = dao.getUser(7);
        testUser.setFirstName("updated");
        dao.updateUser(testUser);

        User updatedUser = dao.getUser(7);
        assertTrue("Did not find correct last name", updatedUser.getFirstName().equals("updated"));
    }

    @Test
    public void deleteUser() throws Exception {
        int testId = 7;
        dao.deleteUser(testId);
        assertNull("user was still found", dao.getUser(testId));
    }
    */

}