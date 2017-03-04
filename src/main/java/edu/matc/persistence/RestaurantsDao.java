package edu.matc.persistence;

import edu.matc.entity.Restaurants;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class RestaurantsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all Restaurants
     *
     * @return All Restaurants
     */
    public List<Restaurants> getAllRestaurants() {
        List<Restaurants> Restaurants = new ArrayList<Restaurants>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Restaurants = session.createCriteria(Restaurants.class).list();
        return Restaurants;
    }

    /**
     * retrieve a restaurant given its name
     *
     * @param restaurantName the restaurant's name
     * @return restaurant
     */
    public Restaurants getRestaurant(String restaurantName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Restaurants restaurant = (Restaurants) session.get(Restaurants.class, restaurantName);
        return restaurant;
    }

    /**
     * add a restaurant
     *
     * @param restaurant
     * @return the name of the inserted restaurant
     */
    public int addRestaurant(Restaurants restaurant) {
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
            Restaurants restaurant =
                    (Restaurants) session.get(Restaurants.class, restaurantName);
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

    public void updateRestaurant(Restaurants restaurant) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Restaurants changeRestaurant =
                    (Restaurants)session.get(Restaurants.class, restaurant.getRestaurantName());
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