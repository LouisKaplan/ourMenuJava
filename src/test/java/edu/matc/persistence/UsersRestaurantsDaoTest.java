package edu.matc.persistence;

import edu.matc.entity.Users;
import edu.matc.entity.Restaurants;
import edu.matc.entity.UsersRestaurants;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsersRestaurantsDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    UsersDao userDao;
    Users testUser;
    Users testUser2;
    int testUserID = 0;

    RestaurantsDao restaurantDao;
    Restaurants daoTestRestaurant;
    Restaurants daoTestRestaurant2;
    String testRestaurantID = "XXX";

    UsersRestaurantsDao userRestaurantDao;
    UsersRestaurants testUserRestaurant;
    int testUserRestaurantID = 0;


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

        restaurantDao = new RestaurantsDao();
        daoTestRestaurant = new Restaurants();
        daoTestRestaurant.setRestaurantName("TestRestaurant");
        daoTestRestaurant.setRestaurantType("Ghost");

        daoTestRestaurant2 = new Restaurants();
        daoTestRestaurant2.setRestaurantName("UpdateRestaurant");
        daoTestRestaurant2.setRestaurantType("Update");

        userRestaurantDao = new UsersRestaurantsDao();
        testUserRestaurant = new UsersRestaurants();
        testUserRestaurant.setUserID(testUser);
        testUserRestaurant.setRestaurantName(daoTestRestaurant);
    }

    @After
    public void cleanup(){
        if (testUserID != 0) {
            userDao.deleteUser(testUserID);
        }

        if (testRestaurantID != "XXX") {
            restaurantDao.deleteRestaurant(testRestaurantID);
        }

        if (testUserRestaurantID != 0) {
            userRestaurantDao.deleteUsersRestaurants(testUserRestaurantID);
        }
    }
/*
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
  */
}
