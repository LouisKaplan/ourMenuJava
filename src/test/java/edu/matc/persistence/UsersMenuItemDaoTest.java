package edu.matc.persistence;

import edu.matc.entity.Users;
import edu.matc.entity.MenuItems;
import edu.matc.entity.UsersMenuItem;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsersMenuItemDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    UsersDao userDao;
    Users testUser;
    int testUserID = 0;

    MenuItemsDao itemDao;
    MenuItems testItem;
    int testItemID =0;

    UsersMenuItemDao userItemDao;
    UsersMenuItem testUserItem;
    int testUserItemID = 0;


    @Before
    public void setup() {
        userDao = new UsersDao();
        testUser = new Users();
        testUser.setFirstName("TestCaseFirst");
        testUser.setLastName("TestCaseLast");
        testUser.setUserRole("Ghost");
        testUser.setUserPassword("TestPassword");

        itemDao = new MenuItemsDao();
        testItem = new MenuItems();
        testItem.setRestaurantName("TestRestaurant");
        testItem.setItemDescription("Tendies");
        testItem.setItemType("TestType");

        userItemDao = new UsersMenuItemDao();
        testUserItem = new UsersMenuItem();
        testUserItem.setUserID(testUser);
        testUserItem.setMenuItemID(testItem);
    }

    @After
    public void cleanup(){
        if (testUserID != 0) {
            userDao.deleteUser(testUserID);
        }

        if (testItemID != 0) {
            itemDao.deleteMenuItem(testItemID);
        }

        if (testUserItemID != 0) {
            userItemDao.deleteUserMenuItem(testUserItemID);
        }
    }

    @Test
    public void getAllUsersMenuItems() throws Exception {
        List<UsersMenuItem> umi = userItemDao.getAllUserMenuItems();
        assertTrue("did not return at least one column", umi.size() > 0);
        log.info("all users: " + umi);
    }

    @Test
    public void getUsersMenuItems() throws Exception {
        testUserItemID = userItemDao.addUserMenuItem(testUserItem);
        assertEquals("userID does not match", testUserItem.getJoinID(), userItemDao.getUserMenuItem(testUserItemID).getJoinID());
        //assertTrue("Did not find correct userID", UMI.getUserID().getUserid().equals(1));
    }
/*
    @Test
    public void addUser() throws Exception {
        newUserTestCase = dao.addUser(testUser);
        assertEquals("actor first name not added", testUser.getFirstName(), dao.getUser(newUserTestCase).getFirstName());
        assertEquals("actor last name not added", testUser.getLastName(), dao.getUser(newUserTestCase).getLastName());
    }

    @Test
    public void updateUser() throws Exception {
        newUserTestCase = dao.addUser(testUser);

        testUser.setFirstName("FirstInProgress");
        testUser.setLastName("LastInProgress");

        dao.updateUser(testUser);
        assertEquals("actor first name not updated", testUser.getFirstName(), dao.getUser(newUserTestCase).getFirstName());
        assertEquals("actor last name not updated", testUser.getLastName(), dao.getUser(newUserTestCase).getLastName());
    }

    @Test
    public void deleteUser() throws Exception {
        dao.addUser(testUser);
        dao.deleteUser(testUser.getUserid());
        assertNull("user was still found", dao.getUser(testUser.getUserid()));
    }
*/
}