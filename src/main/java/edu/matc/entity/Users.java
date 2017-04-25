package edu.matc.entity;

import org.hibernate.annotations.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements java.io.Serializable{

    @Id
    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "userPassword")
    private String userPassword;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userName")
//    private Set<UsersMenuItems> usersMenuItems = new HashSet<MenuItems>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<UsersRestaurants> usersRestaurants = new HashSet<UsersRestaurants>(0);


    public Users() {
    }

    public Users(String userName,
                 String displayName,
                 String userPassword) {
        this.userName = userName;
        this.displayName = displayName;
        this.userPassword = userPassword;
    }

//    public Users(String userName,
//                 String displayName,
//                 String userPassword,
//                 Set<MenuItems> menuItems) {
//        this.userName = userName;
//        this.displayName = displayName;
//        this.userPassword = userPassword;
//        this.menuItems = menuItems;
//    }
//
//    public Users(Set<Restaurants> restaurants,
//                 String userName,
//                 String displayName,
//                 String userPassword) {
//        this.restaurants = restaurants;
//        this.userName = userName;
//        this.displayName = displayName;
//        this.userPassword = userPassword;
//
//    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getDisplayName(){
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public String getUserPassword(){
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


//    public Set<UsersMenuItems> getUsersMenuItems(){
//        return this.usersMenuItems;
//    }
//
//    public void setUsersMenuItems(Set<UsersMenuItems> usersMenuItems) {
//        this.usersMenuItems = usersMenuItems;
//    }


    public Set<UsersRestaurants> getUsersRestaurants(){
        return this.usersRestaurants;
    }

    public void setUsersRestaurants(Set<Restaurants> restaurants) {
        this.usersRestaurants = usersRestaurants;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName=" + userName + '\'' +
                ", displayName=" + displayName + '\'' +
                ", userPassword=" + userPassword + '\'' +
                '}';
    }
}