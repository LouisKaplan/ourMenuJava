package edu.matc.persistence;

import edu.matc.entity.Restaurants;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 9/13/16.
 *
 * @author pwaite
 */
public class RestaurantDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    RestaurantsDao dao;
    Restaurants testRestaurant;
    String restaurantTestID = "XXX";

    @Before
    public void setup() {
        dao = new RestaurantsDao();
        testRestaurant = new Restaurants();

        testRestaurant.setRestaurantName("RestaurantTestCase");
        testRestaurant.setRestaurantType("Ghost");
    }

    @After
    public void cleanup(){
        if (restaurantTestID != "XXX") {
            dao.deleteRestaurant(restaurantTestID);
        }
    }

    @Test
    public void getAllRestaurants() throws Exception {
        List<Restaurants> users = dao.getAllRestaurants();
        assertTrue(users.size() > 0);
        log.info("all users: " + users);
    }

    @Test
    public void getUser() throws Exception {
        Restaurants findRestaurant = dao.getRestaurant("GhostRestaurant");
        assertTrue("Did not find correct restaurant", findRestaurant.getRestaurantType().equals("Ghost"));
        log.info("Restaurant by name: " + findRestaurant.getRestaurantName());
    }

    @Test
    public void addUser() throws Exception {
        restaurantTestID = dao.addRestaurant(testRestaurant);
        assertEquals("Restaurant Name Not Added", testRestaurant.getRestaurantName(), dao.getRestaurant(restaurantTestID).getRestaurantName());
        assertEquals("Restaurant Type Not Added", testRestaurant.getRestaurantType(), dao.getRestaurant(restaurantTestID).getRestaurantType());
    }

    @Test
    public void updateUser() throws Exception {
        restaurantTestID = dao.addRestaurant(testRestaurant);

        testRestaurant.setRestaurantType("RestTypeProgress");

        dao.updateRestaurant(testRestaurant);
        assertEquals("Restaurant Type Not Updated", testRestaurant.getRestaurantType(), dao.getRestaurant(restaurantTestID).getRestaurantType());
    }

    @Test
    public void deleteUser() throws Exception {
        dao.addRestaurant(testRestaurant);
        dao.deleteRestaurant(testRestaurant.getRestaurantName());
        assertNull("user was still found", dao.getRestaurant(testRestaurant.getRestaurantName()));
    }
}