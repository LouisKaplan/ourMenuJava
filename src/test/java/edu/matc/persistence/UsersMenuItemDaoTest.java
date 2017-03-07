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
    Users testUser2;
    int testUserID = 0;

    MenuItemsDao itemDao;
    MenuItems testItem;
    MenuItems testItem2;
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

        testUser2 = new Users();
        testUser2.setFirstName("UpdateFirst");
        testUser2.setLastName("UpdateLast");
        testUser2.setUserRole("Ghost");
        testUser2.setUserPassword("UpdatePassword");

        itemDao = new MenuItemsDao();
        testItem = new MenuItems();
        testItem.setRestaurantName("TestRestaurant");
        testItem.setItemDescription("Tendies");
        testItem.setItemType("TestType");

        testItem2 = new MenuItems();
        testItem2.setRestaurantName("UpdateRestaurant");
        testItem2.setItemDescription("UpdateTendies");
        testItem2.setItemType("UpdateType");

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
        assertEquals("joinID does not match", testUserItem.getJoinID(), userItemDao.getUserMenuItem(testUserItemID).getJoinID());
        assertEquals("userID does not match", testUserItem.getUserID().getUserid(), userItemDao.getUserMenuItem(testUserItemID).getUserID().getUserid());
        assertEquals("itemID does not match", testUserItem.getMenuItemID().getMenuItemID(), userItemDao.getUserMenuItem(testUserItemID).getMenuItemID().getMenuItemID());
    }

    @Test
    public void addUserMenuItem() throws Exception {
        testUserItemID = userItemDao.addUserMenuItem(testUserItem);
        assertEquals("Join not inserted", testUserItem.getJoinID(), userItemDao.getUserMenuItem(testUserItemID).getJoinID());
    }

    @Test
    public void updateUserMenuItem() throws Exception {
        testUserItemID = userItemDao.addUserMenuItem(testUserItem);

        assertEquals("Join not inserted", testUserItem.getJoinID(), userItemDao.getUserMenuItem(testUserItemID).getJoinID());

        testUserItem.setUserID(testUser2);
        testUserItem.setMenuItemID(testItem2);

        userItemDao.updateUserMenuItem(testUserItem);

        assertEquals("userID not updated", testUserItem.getUserID().getUserid(), userItemDao.getUserMenuItem(testUserItemID).getUserID().getUserid());
        assertEquals("itemID not updated", testUserItem.getMenuItemID().getMenuItemID(), userItemDao.getUserMenuItem(testUserItemID).getMenuItemID().getMenuItemID());
    }

    @Test
    public void deleteUserMenuItem() throws Exception {
        userItemDao.addUserMenuItem(testUserItem);
        userItemDao.deleteUserMenuItem(testUserItem.getJoinID());
        assertNull("userMenuItem was still found", userItemDao.getUserMenuItem(testUserItem.getJoinID()));
    }
}