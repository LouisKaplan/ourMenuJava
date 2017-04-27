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
    RestaurantsDao restaurantDao;
    UsersRestaurantsDao userRestaurantDao;

    Users testUser;
    Users testUser2;
    String testUserName = "XXX";
    String testUserName2 = "XXX";

    Restaurants daoTestRestaurant;
    Restaurants daoTestRestaurant2;
    String testRestaurantName = "XXX";
    String testRestaurantName2 = "XXX";

    UsersRestaurants testUserRestaurant;
    int testUserRestaurantID = 0;


    @Before
    public void setup() {
        userDao = new UsersDao();
        restaurantDao = new RestaurantsDao();
        userRestaurantDao = new UsersRestaurantsDao();


        testUser = new Users();
        testUser.setUserName("FirstTestUser");
        testUser.setDisplayName("FirstTestDisplay");
        testUser.setUserPassword("FirstTestPass");

        testUser2 = new Users();
        testUser2.setUserName("SecondTestUser");
        testUser2.setDisplayName("SecondTestDisplay");
        testUser2.setUserPassword("SecondTestPass");


        daoTestRestaurant = new Restaurants();
        daoTestRestaurant.setRestaurantName("FirstTestRestaurant");
        daoTestRestaurant.setRestaurantType("Ghost");

        daoTestRestaurant2 = new Restaurants();
        daoTestRestaurant2.setRestaurantName("SecondTestRestaurant");
        daoTestRestaurant2.setRestaurantType("Update");


        testUserRestaurant = new UsersRestaurants();
        testUserRestaurant.setUsers(testUser);
        testUserRestaurant.setRestaurants(daoTestRestaurant);
        testUserRestaurant.setUserRating(4);
    }

    @After
    public void cleanup(){

        if (testUserRestaurantID != 0) {
            userRestaurantDao.deleteUsersRestaurants(testUserRestaurantID);
        }

        if (testUserName != "XXX") {
            userDao.deleteUser(testUserName);
        }

        if (testUserName2 != "XXX") {
            userDao.deleteUser(testUserName2);
        }

        if (testRestaurantName != "XXX") {
            restaurantDao.deleteRestaurant(testRestaurantName);
        }

        if (testRestaurantName2 != "XXX") {
            restaurantDao.deleteRestaurant(testRestaurantName2);
        }
    }

    @Test
    public void getAllUsersRestaurants() throws Exception {
        List<UsersRestaurants> ur = userRestaurantDao.getAllUsersRestaurants();
        assertTrue("did not return at least one column", ur.size() > 0);
        log.info("all users: " + ur);
    }

    @Test
    public void getUsersRestaurants() throws Exception {
        testUserName = userDao.addUser(testUser);
        testRestaurantName = restaurantDao.addRestaurant(daoTestRestaurant);
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        assertEquals("joinID does not match",
                testUserRestaurant.getUserRestID(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserRestID());
        assertEquals("userName does not match",
                testUserRestaurant.getUsers().getUserName(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUsers().getUserName());
        assertEquals("itemID does not match",
                testUserRestaurant.getRestaurants().getRestaurantName(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getRestaurants().getRestaurantName());
    }

    @Test
    public void addUserRestaurants() throws Exception {
        testUserName = userDao.addUser(testUser);
        testRestaurantName = restaurantDao.addRestaurant(daoTestRestaurant);
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        assertEquals("joinID does not match",
                testUserRestaurant.getUserRestID(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserRestID());
    }

    @Test
    public void updateUserRestaurant() throws Exception {
        testUserName = userDao.addUser(testUser);
        testUserName2 = userDao.addUser(testUser2);
        testRestaurantName = restaurantDao.addRestaurant(daoTestRestaurant);
        testRestaurantName2 = restaurantDao.addRestaurant(daoTestRestaurant2);
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);

        assertEquals("joinID does not match",
                testUserRestaurant.getUserRestID(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserRestID());

        testUserRestaurant.setUsers(testUser2);
        testUserRestaurant.setRestaurants(daoTestRestaurant2);

        userRestaurantDao.updateUsersRestaurants(testUserRestaurant);

        assertEquals("userID not updated",
                testUserRestaurant.getUsers().getUserName(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUsers().getUserName());
        assertEquals("restaurantName not updated",
                testUserRestaurant.getRestaurants().getRestaurantName(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getRestaurants().getRestaurantName());

    }

    @Test
    public void deleteUserRestaurant() throws Exception {
        testUserName = userDao.addUser(testUser);
        testRestaurantName = restaurantDao.addRestaurant(daoTestRestaurant);
        userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        userRestaurantDao.deleteUsersRestaurants(testUserRestaurant.getUserRestID());
        assertNull("userRestaurant was still found",
                userRestaurantDao.getUsersRestaurants(testUserRestaurant.getUserRestID()));
    }

}
