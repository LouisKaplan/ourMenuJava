package edu.matc.persistence;

import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


public class UsersDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all Users
     *
     * @return All Users
     */
    public List<Users> getAllUsers() {
        List<Users> Users = new ArrayList<Users>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Users = session.createCriteria(Users.class).list();
        return Users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public Users getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Users user = (Users) session.get(Users.class, id);
        return user;
    }

    /**
     * add a user
     *
     * @param firstName, lastName, userRole, userPassword
     * @return the id of the inserted record
     */

    public int addUser(String firstName, String lastName, String userRole, String userPassword) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = 0;
        try{
            tx = session.beginTransaction();
            Users user = new Users(firstName, lastName, userRole, userPassword);
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
            Users user =
                    (Users)session.get(Users.class, id);
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
            Users changeUser =
                    (Users)session.get(Users.class, user.getUserid());
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