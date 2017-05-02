package edu.matc.persistence;

import edu.matc.entity.MenuItems;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class MenuItemsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all MenuItems
     *
     * @return All MenuItems
     */
    public List<MenuItems> getAllMenuItems() {
        List<MenuItems> menuItems = new ArrayList<MenuItems>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            menuItems = session.createCriteria(MenuItems.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return menuItems;
    }

    public List<MenuItems> getMenuItemsByRestaurant(String restaurantName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<MenuItems> menuItems = null;
        try {
            menuItems = session.createCriteria(MenuItems.class).add
                    (Restrictions.eq("restaurantName",restaurantName)).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }
        return menuItems;
    }

    public List<MenuItems> getMenuItemsByID(int id) {
        List<MenuItems> menuItems = new ArrayList<MenuItems>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            menuItems = session.createCriteria(MenuItems.class).add
                    (Restrictions.eq("menuItemID",id)).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception - getMenuItemsByID", e);
        }finally {
            session.close();
        }
        return menuItems;
    }

    public List<MenuItems> getMenuItemsByName(String description) {
        List<MenuItems> menuItems = new ArrayList<MenuItems>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            menuItems = session.createCriteria(MenuItems.class).add
                    (Restrictions.eq("itemDescription", description)).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception - getMenuItemsByID", e);
        }finally {
            session.close();
        }
        return menuItems;
    }



    /**
     * retrieve a menuItem given its ID
     *
     * @param id the menuItem's id
     * @return menuItem
     */
    public MenuItems getMenuItem(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        MenuItems menuItems = null;
        try {
            menuItems = (MenuItems) session.get(MenuItems.class, id);
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return menuItems;
    }

    /**
     * add a user
     *
     * @param menuItem
     * @return the id of the menuItem
     */

    public int addMenuItem(MenuItems menuItem) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;
        try{
            tx = session.beginTransaction();
            id = (Integer)session.save(menuItem);
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
     * @param id the menuItem's id
     */
    public void deleteMenuItem(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            MenuItems menuItem = (MenuItems)session.get(MenuItems.class, id);
            session.delete(menuItem);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Update the menuItem
     * @param menuItem
     */

    public void updateMenuItem(MenuItems menuItem) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(menuItem);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}