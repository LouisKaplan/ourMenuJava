package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="menuItems", catalog = "ourMenu")
public class MenuItems implements java.io.Serializable{

    private int menuItemID;
    private String restaurantName;
    private String itemDescription;
    private String itemType;
    private Set<Users> users = new HashSet<Users>(0);
//    private Set<UsersMenuItems> usersMenuItems = new HashSet<UsersMenuItem>(0);

    public MenuItems() {
    }

    public MenuItems(String restaurantName,
                     String itemDescription,
                     String itemType) {
        this.restaurantName = restaurantName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
    }

    public MenuItems(String restaurantName,
                     String itemDescription,
                     String itemType,
                     Set<Users> users) {
        this.restaurantName = restaurantName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.users = users;
    }

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



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menuItems")
    public Set<Users> getUsers(){
        return this.users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }



//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItemID", cascade = CascadeType.ALL)
//    public Set<UsersMenuItem> getUsersMenuItem(){
//        return this.usersMenuItem;
//    }
//
//    public void setUsersMenuItem(Set<UsersMenuItem> usersMenuItem) {
//        this.usersMenuItem = usersMenuItem;
//    }


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