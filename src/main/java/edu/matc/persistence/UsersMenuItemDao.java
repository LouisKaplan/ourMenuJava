//package edu.matc.persistence;
//
//import edu.matc.entity.UsersMenuItem;
//import edu.matc.entity.UsersMenuItemID;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class UsersMenuItemDao {
//
//    private final Logger log = Logger.getLogger(this.getClass());
//
//    /** Return a list of all UsersMenuItem
//     *
//     * @return All UsersMenuItem
//     */
//    public List<UsersMenuItem> getAllUserMenuItems() {
//        List<UsersMenuItem> usersMenuItems = new ArrayList<UsersMenuItem>();
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        try {
//            usersMenuItems = session.createCriteria(UsersMenuItem.class).list();
//        } catch (HibernateException e) {
//            log.error("Hibernate Exception", e);
//        }finally {
//            session.close();
//        }
//        return usersMenuItems;
//    }
//
//    /**
//     * retrieve a usersMenuItem given its ID
//     *
//     * @param id the usersMenuItem's id
//     * @return usersMenuItem
//     */
//    public UsersMenuItem getUserMenuItem(int id) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        UsersMenuItem usersMenuItem = null;
//        try {
//            usersMenuItem = (UsersMenuItem) session.get(UsersMenuItem.class, id);
//            return usersMenuItem;
//        } catch (HibernateException e) {
//            log.error("Hibernate Exception", e);
//        } finally {
//            session.close();
//        }
//        return usersMenuItem;
//    }
//
//    /**
//     * add a user
//     *
//     * @param usersMenuItem
//     * @return the id of the usersMenuItem
//     */
//
//    public int addUserMenuItem(UsersMenuItem usersMenuItem) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//        int id = 0;
//        try{
//            tx = session.beginTransaction();
//            id = (Integer)session.save(usersMenuItem);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        return id;
//    }
//
//    /**
//     * delete a usersMenuItem by id
//     * @param id the usersMenuItem's id
//     */
//    public void deleteUserMenuItem(int id) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            UsersMenuItem usersMenuItem = (UsersMenuItem)session.get(UsersMenuItem.class, id);
//            session.delete(usersMenuItem);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//    /**
//     * Update the usersMenuItem
//     * @param usersMenuItem
//     */
//
//    public void updateUserMenuItem(UsersMenuItem usersMenuItem) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            session.update(usersMenuItem);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//}