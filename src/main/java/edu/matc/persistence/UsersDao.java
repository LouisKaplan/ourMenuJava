package edu.matc.persistence;

import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;


public class UsersDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all Users
     *
     * @return All Users
     */
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            users = session.createCriteria(Users.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return users;
    }

    public List<Users> getUserByDisplayName(String displayName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Users> user = null;
        try {
            user = session.createCriteria(Users.class).add
                    (Restrictions.eq("displayName",displayName)).list();

        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return user;
    }


    /**
     * retrieve a user given their id
     *
     * @param userName the user's userName
     * @return user
     */
    public Users getUser(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Users user = null;
        try {
            user = (Users) session.get(Users.class, userName);
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the userName of the inserted record
     */

    public String addUser(Users user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String id = null;
        try{
            tx = session.beginTransaction();
            id = (String)session.save(user);
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
     * delete a user by userName
     * @param userName the user's userName
     */
    public void deleteUser(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Users user = (Users)session.get(Users.class, userName);
            session.delete(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(Users user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}