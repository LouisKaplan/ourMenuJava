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
        daoTestRestaurant.setRestaurantName("TestRestaurant2");
        daoTestRestaurant.setRestaurantType("Ghost");

        daoTestRestaurant2 = new Restaurants();
        daoTestRestaurant2.setRestaurantName("UpdateRestaurant2");
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

    @Test
    public void getAllUsersRestaurants() throws Exception {
        List<UsersRestaurants> ur = userRestaurantDao.getAllUsersRestaurants();
        assertTrue("did not return at least one column", ur.size() > 0);
        log.info("all users: " + ur);
    }

    @Test
    public void getUsersRestaurants() throws Exception {
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        assertEquals("joinID does not match", testUserRestaurant.getLinkID(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getLinkID());
        assertEquals("userID does not match", testUserRestaurant.getUserID().getUserid(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserID().getUserid());
        assertEquals("itemID does not match", testUserRestaurant.getRestaurantName().getRestaurantName(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getRestaurantName().getRestaurantName());
    }

    @Test
    public void addUserRestaurants() throws Exception {
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        assertEquals("joinID does not match", testUserRestaurant.getLinkID(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getLinkID());
    }

    @Test
    public void updateUserRestaurant() throws Exception {
        testUserRestaurantID = userRestaurantDao.addUsersRestaurants(testUserRestaurant);

        assertEquals("Join not inserted", testUserRestaurant.getLinkID(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getLinkID());

        testUserRestaurant.setUserID(testUser2);
        testUserRestaurant.setRestaurantName(daoTestRestaurant2);

        userRestaurantDao.updateUsersRestaurants(testUserRestaurant);

        assertEquals("userID not updated", testUserRestaurant.getUserID().getUserid(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getUserID().getUserid());
        assertEquals("restaurantName not updated", testUserRestaurant.getRestaurantName().getRestaurantName(), userRestaurantDao.getUsersRestaurants(testUserRestaurantID).getRestaurantName().getRestaurantName());

    }

    @Test
    public void deleteUserRestaurant() throws Exception {
        userRestaurantDao.addUsersRestaurants(testUserRestaurant);
        userRestaurantDao.deleteUsersRestaurants(testUserRestaurant.getLinkID());
        assertNull("userRestaurant was still found", userRestaurantDao.getUsersRestaurants(testUserRestaurant.getLinkID()));
    }

}
