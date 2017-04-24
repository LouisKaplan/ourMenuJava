package edu.matc.persistence;

import edu.matc.entity.Restaurants;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
        log.info(testRestaurant.getRestaurantName());
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
    public void getRestaurant() throws Exception {
        restaurantTestID = dao.addRestaurant(testRestaurant);
        Restaurants findRestaurant = dao.getRestaurant("RestaurantTestCase");
        log.info("TESTONE: " + findRestaurant);
        assertTrue("Did not find correct restaurant", findRestaurant.getRestaurantType().equals("Ghost"));
        log.info("Restaurant by name: " + findRestaurant.getRestaurantName());
    }

    @Test
    public void addRestaurant() throws Exception {
        restaurantTestID = dao.addRestaurant(testRestaurant);
        assertEquals("Restaurant Name Not Added", testRestaurant.getRestaurantName(), dao.getRestaurant(restaurantTestID).getRestaurantName());
        assertEquals("Restaurant Type Not Added", testRestaurant.getRestaurantType(), dao.getRestaurant(restaurantTestID).getRestaurantType());
    }

    @Test
    public void updateRestaurant() throws Exception {
        restaurantTestID = dao.addRestaurant(testRestaurant);

        testRestaurant.setRestaurantType("RestTypeProgress");

        dao.updateRestaurant(testRestaurant);
        assertEquals("Restaurant Type Not Updated", testRestaurant.getRestaurantType(), dao.getRestaurant(restaurantTestID).getRestaurantType());
    }

    @Test
    public void deleteRestaurant() throws Exception {
        dao.addRestaurant(testRestaurant);
        dao.deleteRestaurant(testRestaurant.getRestaurantName());
        assertNull("user was still found", dao.getRestaurant(testRestaurant.getRestaurantName()));
    }
}