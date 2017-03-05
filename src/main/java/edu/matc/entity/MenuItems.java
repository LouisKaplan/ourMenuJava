package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="menuItems")
public class MenuItems {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "menuItemID")
    private int menuItemID;

    @Column(name = "restaurantName")
    private String restaurantName;

    @Column(name = "itemDescription")
    private String itemDescription;

    @Column(name = "itemType")
    private String itemType;

    public MenuItems() {
    }

    public MenuItems(String restaurantName,
                     String itemDescription,
                     String itemType) {
        this.restaurantName = restaurantName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int userid) {
        this.menuItemID = menuItemID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemID=" + menuItemID + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemType=" + itemType + '\'' +
                '}';
    }
}