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
        List<Restaurants> restaurants = new ArrayList<Restaurants>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            restaurants = session.createCriteria(Restaurants.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return restaurants;
    }

    /**
     * retrieve a restaurant given its name
     *
     * @param restaurantName the restaurant's name
     * @return restaurant
     */
    public Restaurants getRestaurant(String restaurantName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Restaurants restaurants = null;
        try {
            restaurants = (Restaurants) session.get(Restaurants.class, restaurantName);
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return restaurants;
    }

    /**
     * add a restaurant
     *
     * @param restaurant
     * @return the name of the inserted restaurant
     */

    public String addRestaurant(Restaurants restaurant) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String id = null;
        try{
            tx = session.beginTransaction();
            id = (String) session.save(restaurant);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return id;
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
            Restaurants restaurant = (Restaurants)session.get(Restaurants.class, restaurantName);
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
            session.update(restaurant);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}