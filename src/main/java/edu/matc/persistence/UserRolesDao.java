package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserRolesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all UserRoles
     *
     * @return All UserRoles
     */
    public List<UserRoles> getAllUserRoles() {
        List<UserRoles> userRoles = new ArrayList<UserRoles>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            userRoles = session.createCriteria(UserRoles.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return userRoles;
    }

    /**
     * retrieve a userRoles given its userName
     *
     * @param userName the userRoles's userName
     * @return userRoles
     */
    public UserRoles getMenuItem(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRoles userRoles = null;
        try {
            userRoles = (UserRoles) session.get(UserRoles.class, userName);
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return userRoles;
    }

    /**
     * add a user
     *
     * @param userRoles
     * @return the id of the menuItem
     */

    public String addUserRole(UserRoles userRoles) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String id = null;
        try{
            tx = session.beginTransaction();
            id = (String)session.save(userRoles);
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
     * delete a menuItem by id
     * @param userName the UserRole's userName
     */
    public void deleteUserRole(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            UserRoles userRole = (UserRoles)session.get(UserRoles.class, userName);
            session.delete(userRole);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Update the userRole
     * @param userRole
     */

    public void updateUserRole(UserRoles userRole) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(userRole);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
