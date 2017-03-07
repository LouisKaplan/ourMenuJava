package edu.matc.persistence;

import edu.matc.entity.UsersMenuItem;
import edu.matc.entity.UsersRestaurants;
import edu.matc.entity.UsersRestaurantsID;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class UsersRestaurantsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all UsersRestaurants
     *
     * @return All UsersRestaurants
     */
    public List<UsersRestaurants> getAllUsersRestaurants() {
        List<UsersRestaurants> usersRestaurants = new ArrayList<UsersRestaurants>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            usersRestaurants = session.createCriteria(UsersRestaurants.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return usersRestaurants;
    }

    /**
     * retrieve a UsersRestaurants given its ID
     *
     * @param id the UsersRestaurants's id
     * @return UsersRestaurants
     */
    public UsersRestaurants getUsersRestaurants(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UsersRestaurants usersRestaurants = null;
        try {
            usersRestaurants = (UsersRestaurants) session.get(UsersRestaurants.class, id);
            return usersRestaurants;
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return usersRestaurants;
    }

    /**
     * add a user
     *
     * @param usersRestaurants
     * @return the id of the usersRestaurants
     */

    public int addUsersRestaurants(UsersRestaurants usersRestaurants) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;
        try{
            tx = session.beginTransaction();
            id = (Integer)session.save(usersRestaurants);
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
     * delete a usersMenuItem by id
     * @param id the usersMenuItem's id
     */
    public void deleteUsersRestaurants(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            UsersRestaurants usersRestaurants = (UsersRestaurants) session.get(UsersRestaurants.class, id);
            session.delete(usersRestaurants);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Update the usersRestaurants
     * @param usersRestaurants
     */

    public void updateUsersRestaurants(UsersRestaurants usersRestaurants) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(usersRestaurants);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}