package edu.matc.persistence;

import edu.matc.entity.restaurants;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class restaurantsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all restaurants
     *
     * @return All restaurants
     */
    public List<restaurants> getAllRestaurants() {
        List<restaurants> restaurants = new ArrayList<restaurants>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        restaurants = session.createCriteria(restaurants.class).list();
        return restaurants;
    }

    /**
     * retrieve a restaurant given its name
     *
     * @param restaurantName the restaurant's name
     * @return restaurant
     */
    public restaurants getRestaurant(String restaurantName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        restaurants restaurant = (restaurants) session.get(restaurants.class, restaurantName);
        return restaurant;
    }

    /**
     * add a restaurant
     *
     * @param restaurant
     * @return the name of the inserted restaurant
     */
    public int addRestaurant(restaurants restaurant) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;
        try{
            tx = session.beginTransaction();
            id = (Integer) session.save(restaurant);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return id;
        }
    }

    /**
     * delete a restaurant by name
     * @param restaurantName the restaurant's name
     */
    public void deleteRestaurant(String restaurantName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            restaurants restaurant =
                    (restaurants) session.get(restaurants.class, restaurantName);
            session.delete(restaurant);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    /**
     * Update the restaurant
     * @param restaurant
     */

    public void updateRestaurant(restaurants restaurant) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            restaurants changeRestaurant =
                    (restaurants)session.get(restaurants.class, restaurant.getRestaurantName());
            changeRestaurant.setRestaurantName(restaurant.getRestaurantName());
            session.update(changeRestaurant);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}