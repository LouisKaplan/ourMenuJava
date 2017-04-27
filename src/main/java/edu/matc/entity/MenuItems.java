package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="menuItems")
public class MenuItems implements java.io.Serializable{

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

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menuItems")
//    private Set<Users> users = new HashSet<Users>(0);

    public MenuItems() {
    }

//    public MenuItems(String restaurantName,
//                     String itemDescription,
//                     String itemType) {
//        this.restaurantName = restaurantName;
//        this.itemDescription = itemDescription;
//        this.itemType = itemType;
//    }

//    public MenuItems(String restaurantName,
//                     String itemDescription,
//                     String itemType,
//                     Set<Users> users) {
//        this.restaurantName = restaurantName;
//        this.itemDescription = itemDescription;
//        this.itemType = itemType;
//        this.users = users;
//    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
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


//    public Set<Users> getUsers(){
//        return this.users;
//    }
//
//    public void setUsers(Set<Users> users) {
//        this.users = users;
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