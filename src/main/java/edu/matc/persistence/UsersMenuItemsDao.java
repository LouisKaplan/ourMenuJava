package edu.matc.persistence;

import edu.matc.entity.UsersMenuItems;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;


public class UsersMenuItemsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all UsersMenuItems
     *
     * @return All UsersMenuItems
     */
    public List<UsersMenuItems> getAllUsersMenuItems() {
        List<UsersMenuItems> usersMenuItems = new ArrayList<UsersMenuItems>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            usersMenuItems = session.createCriteria(UsersMenuItems.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return usersMenuItems;
    }

    /**
     * retrieve a usersMenuItem given its ID
     *
     * @param id the usersMenuItems's id
     * @return usersMenuItems
     */
    public UsersMenuItems getUsersMenuItems(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UsersMenuItems usersMenuItems = null;
        try {
            usersMenuItems = (UsersMenuItems) session.get(UsersMenuItems.class, id);
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return usersMenuItems;
    }

    /**
     * add a user
     *
     * @param usersMenuItems
     * @return the id of the usersMenuItems
     */

    public int addUserMenuItem(UsersMenuItems usersMenuItems) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;
        try{
            tx = session.beginTransaction();
            id = (Integer)session.save(usersMenuItems);
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
     * delete a usersMenuItems by id
     * @param id the usersMenuItems's id
     */
    public void deleteUserMenuItem(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            UsersMenuItems usersMenuItems = (UsersMenuItems)session.get(UsersMenuItems.class, id);
            session.delete(usersMenuItems);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Update the usersMenuItems
     * @param usersMenuItems
     */

    public void updateUserMenuItem(UsersMenuItems usersMenuItems) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(usersMenuItems);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}