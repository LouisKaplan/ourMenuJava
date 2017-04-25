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

    Restaurants daoTestRestaurant;
    Restaurants daoTestRestaurant2;
    String testRestaurantName = "XXX";

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
        if (testUserName != "XXX") {
            userDao.deleteUser(testUserName);
        }

        if (testRestaurantName != "XXX") {
            restaurantDao.deleteRestaurant(testRestaurantName);
        }

        if (testUserRestaurantID != 0) {
            userRestaurantDao.deleteUsersRestaurants(testUserRestaurantID);
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
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        assertEquals("joinID does not match",
                testUserRestaurant.getUserRestID(),
                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserRestID());
//        assertEquals("userID does not match",
//                testUserRestaurant.getUserID().getUserid(),
//                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserID().getUserid());
//        assertEquals("itemID does not match",
//                testUserRestaurant.getRestaurantName().getRestaurantName(),
//                userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getRestaurantName().getRestaurantName());
    }
//
//    @Test
//    public void addUserRestaurants() throws Exception {
//        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
//        assertEquals("joinID does not match", testUserRestaurant.getLinkID(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getLinkID());
//    }
//
//    @Test
//    public void updateUserRestaurant() throws Exception {
//        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
//
//        assertEquals("Join not inserted", testUserRestaurant.getLinkID(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getLinkID());
//
//        testUserRestaurant.setUserID(testUser2);
//        testUserRestaurant.setRestaurantName(daoTestRestaurant2);
//
//        userRestaurantDao.updateUsersRestaurants(testUserRestaurant);
//
//        assertEquals("userID not updated", testUserRestaurant.getUserID().getUserid(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserID().getUserid());
//        assertEquals("restaurantName not updated", testUserRestaurant.getRestaurantName().getRestaurantName(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getRestaurantName().getRestaurantName());
//
//    }
//
//    @Test
//    public void deleteUserRestaurant() throws Exception {
//        userRestaurantDao.addUsersRestaurants(testUserRestaurant);
//        userRestaurantDao.deleteUsersRestaurants(testUserRestaurant.getLinkID());
//        assertNull("userRestaurant was still found", userRestaurantDao.getUsersRestaurants(testUserRestaurant.getLinkID()));
//    }

}
