package edu.matc.persistence;

import edu.matc.entity.Users;
import edu.matc.entity.MenuItems;
import edu.matc.entity.UsersMenuItems;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsersMenuItemDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    UsersDao userDao;
    MenuItemsDao itemDao;
    UsersMenuItemsDao userItemDao;

    Users testUser;
    Users testUser2;
    String testUserName = "XXX";
    String testUserName2 = "XXX";

    MenuItems testItem;
    MenuItems testItem2;
    int testItemID = 0;
    int testItemID2 = 0;

    UsersMenuItems testUserItem;
    int testUserItemID = 0;


    @Before
    public void setup() {
        userDao = new UsersDao();
        itemDao = new MenuItemsDao();
        userItemDao = new UsersMenuItemsDao();


        testUser = new Users();
        testUser.setUserName("FirstTestUser");
        testUser.setDisplayName("FirstTestDisplay");
        testUser.setUserPassword("FirstTestPass");

        testUser2 = new Users();
        testUser2.setUserName("SecondTestUser");
        testUser2.setDisplayName("SecondTestDisplay");
        testUser2.setUserPassword("SecondTestPass");


        testItem = new MenuItems();
        testItem.setRestaurantName("GhostRestaurant");
        testItem.setItemDescription("Nuggets");
        testItem.setItemType("TestType");

        testItem2 = new MenuItems();
        testItem2.setRestaurantName("GhostRestaurant");
        testItem2.setItemDescription("UpdateNuggets");
        testItem2.setItemType("UpdateType");


        testUserItem = new UsersMenuItems();
        testUserItem.setUserName(testUser);
        testUserItem.setMenuItemID(testItem);
    }

    @After
    public void cleanup(){

        if (testUserItemID != 0) {
            userItemDao.deleteUserMenuItem(testUserItemID);
        }

        if (testUserName != "XXX") {
            userDao.deleteUser(testUserName);
        }

        if (testUserName2 != "XXX") {
            userDao.deleteUser(testUserName2);
        }

        if (testItemID != 0) {
            itemDao.deleteMenuItem(testItemID);
        }

        if (testItemID2 != 0) {
            itemDao.deleteMenuItem(testItemID2);
        }


    }

    @Test
    public void getAllUsersMenuItems() throws Exception {
        List<UsersMenuItems> umi = userItemDao.getAllUsersMenuItems();
        assertTrue("did not return at least one column", umi.size() > 0);
        log.info("all users: " + umi);
    }

    @Test
    public void getUsersMenuItems() throws Exception {
        testUserName = userDao.addUser(testUser);
        testItemID = itemDao.addMenuItem(testItem);
        testUserItemID = userItemDao.addUserMenuItem(testUserItem);
        assertEquals("UserItemID does not match",
                testUserItem.getUserItemID(),
                userItemDao.getUsersMenuItems(testUserItemID).getUserItemID());
        assertEquals("userName does not match",
                testUserItem.getUserName().getUserName(),
                userItemDao.getUsersMenuItems(testUserItemID).getUserName().getUserName());
        assertEquals("itemID does not match",
                testUserItem.getMenuItemID().getMenuItemID(),
                userItemDao.getUsersMenuItems(testUserItemID).getMenuItemID().getMenuItemID());
    }

    @Test
    public void addUserMenuItem() throws Exception {
        testUserName = userDao.addUser(testUser);
        testItemID = itemDao.addMenuItem(testItem);
        testUserItemID = userItemDao.addUserMenuItem(testUserItem);
        assertEquals("Join not inserted",
                testUserItem.getUserItemID(),
                userItemDao.getUsersMenuItems(testUserItemID).getUserItemID());
    }

    @Test
    public void updateUserMenuItem() throws Exception {
        testUserName = userDao.addUser(testUser);
        testUserName2 = userDao.addUser(testUser2);
        testItemID = itemDao.addMenuItem(testItem);
        testItemID2 = itemDao.addMenuItem(testItem2);
        testUserItemID = userItemDao.addUserMenuItem(testUserItem);

        assertEquals("Join not inserted",
                testUserItem.getUserItemID(),
                userItemDao.getUsersMenuItems(testUserItemID).getUserItemID());

        testUserItem.setUserName(testUser2);
        testUserItem.setMenuItemID(testItem2);

        userItemDao.updateUserMenuItem(testUserItem);

        assertEquals("userID not updated",
                testUserItem.getUserName().getUserName(),
                userItemDao.getUsersMenuItems(testUserItemID).getUserName().getUserName());
        assertEquals("itemID not updated",
                testUserItem.getMenuItemID().getMenuItemID(),
                userItemDao.getUsersMenuItems(testUserItemID).getMenuItemID().getMenuItemID());
    }

    @Test
    public void deleteUserMenuItem() throws Exception {
        testUserName = userDao.addUser(testUser);
        testItemID = itemDao.addMenuItem(testItem);
        userItemDao.addUserMenuItem(testUserItem);
        userItemDao.deleteUserMenuItem(testUserItem.getUserItemID());
        assertNull("userMenuItem was still found",
                userItemDao.getUsersMenuItems(testUserItem.getUserItemID()));
    }
}