package edu.matc.persistence;

import edu.matc.entity.MenuItems;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MenuItemsDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    MenuItemsDao dao;
    MenuItems testMenuItem;
    int menuItemTestID = 0;

    @Before
    public void setup() {
        dao = new MenuItemsDao();
        testMenuItem = new MenuItems();

        testMenuItem.setRestaurantName("GhostRestaurant");
        testMenuItem.setItemDescription("Tendies");
        testMenuItem.setItemType("Ghost");
    }

    @After
    public void cleanup(){
        if (menuItemTestID != 0) {
            dao.deleteMenuItem(menuItemTestID);
        }
    }

    @Test
    public void getAllMenuItems() throws Exception {
        List<MenuItems> menuItems = dao.getAllMenuItems();
        assertTrue(menuItems.size() > 0);
        log.info("all menu items2: " + menuItems);
    }

    @Test
    public void getMenuItem() throws Exception {
        MenuItems findMenuItem = dao.getMenuItem(1);
        assertTrue("Did not find correct menu item", findMenuItem.getItemDescription().equals("Tendies"));
        log.info("menuItem by ID: " + findMenuItem.getItemDescription());
    }

    @Test
    public void addMenuItem() throws Exception {
        menuItemTestID = dao.addMenuItem(testMenuItem);
        assertEquals("Item description not added", testMenuItem.getItemDescription(), dao.getMenuItem(menuItemTestID).getItemDescription());
        assertEquals("Item type not added", testMenuItem.getItemType(), dao.getMenuItem(menuItemTestID).getItemType());
    }

    @Test
    public void updateMenuItem() throws Exception {
        menuItemTestID = dao.addMenuItem(testMenuItem);

        testMenuItem.setItemDescription("McRib");
        testMenuItem.setItemType("Sandwich");

        dao.updateMenuItem(testMenuItem);
        assertEquals("item description not updated", testMenuItem.getItemDescription(), dao.getMenuItem(menuItemTestID).getItemDescription());
        assertEquals("item type not updated", testMenuItem.getItemType(), dao.getMenuItem(menuItemTestID).getItemType());
    }

    @Test
    public void deleteMenuItem() throws Exception {
        dao.addMenuItem(testMenuItem);
        dao.deleteMenuItem(testMenuItem.getMenuItemID());
        assertNull("user was still found", dao.getMenuItem(testMenuItem.getMenuItemID()));
    }

}