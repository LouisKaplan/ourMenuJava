package edu.matc.persistence;

import edu.matc.entity.users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


public class usersDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<users> getAllUsers() {
        List<users> users = new ArrayList<users>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(users.class).list();
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public users getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users user = (users) session.get(users.class, id);
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(users user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;
        try{
            tx = session.beginTransaction();
            id = (Integer) session.save(user);
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
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            users user =
                    (users)session.get(users.class, id);
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

    public void updateUser(users user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            users changeUser =
                    (users)session.get(users.class, user.getUserid());
            changeUser.setFirstName(user.getFirstName());
            changeUser.setLastName(user.getLastName());
            changeUser.setUserid(user.getUserid());
            changeUser.setUserRole(user.getUserRole());
            changeUser.setUserPassword(user.getUserPassword());
            session.update(changeUser);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}