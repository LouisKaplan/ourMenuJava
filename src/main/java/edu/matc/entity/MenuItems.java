package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="menuItems")
public class MenuItems implements Serializable{

    private int menuItemID;
    private String restaurantName;
    private String itemDescription;
    private String itemType;
    private Set<UsersMenuItem> usersMenuItem = new HashSet<UsersMenuItem>(0);

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "menuItemID")
    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }


    @Column(name = "restaurantName")
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }


    @Column(name = "itemDescription")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Column(name = "itemType")
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public MenuItems() {
    }

    public MenuItems(String restaurantName,
                     String itemDescription,
                     String itemType) {
        this.restaurantName = restaurantName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItemID", cascade = CascadeType.ALL)
    public Set<UsersMenuItem> getUsersMenuItem(){
        return this.usersMenuItem;
    }

    public void setUsersMenuItem(Set<UsersMenuItem> usersMenuItem) {
        this.usersMenuItem = usersMenuItem;
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