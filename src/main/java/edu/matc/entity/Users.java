package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users", catalog = "ourMenu", uniqueConstraints = {
        @UniqueConstraint(columnNames = "userName")
})
public class Users implements java.io.Serializable{

    private String userName;
    private String displayName;
    private String userPassword;
    private Set<MenuItems> menuItems = new HashSet<MenuItems>(0);
//    private Set<UsersMenuItems> usersMenuItems = new HashSet<UsersMenuItems>(0);
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

    public Users(String userName,
                 String displayName,
                 String userPassword,
                 Set<MenuItems> menuItems) {
        this.userName = userName;
        this.displayName = displayName;
        this.userPassword = userPassword;
        this.menuItems = menuItems;
    }

    public Users(Set<UsersRestaurants> usersRestaurants,
                 String userName,
                 String displayName,
                 String userPassword) {
        this.userName = userName;
        this.displayName = displayName;
        this.userPassword = userPassword;
        this.usersRestaurants = usersRestaurants;
    }

    @Id
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "displayName")
    public String getDisplayName(){
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Column(name = "userPassword")
    public String getUserPassword(){
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "UsersMenuItems", catalog= "ourMenu", joinColumns = {
            @JoinColumn(name = "userName")
    }, inverseJoinColumns = {
            @JoinColumn(name = "menuItemID")
    })
    public Set<MenuItems> getMenuItems(){
        return this.menuItems;
    }

    public void setMenuItems(Set<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userName", cascade = CascadeType.ALL)
//    public Set<UsersMenuItems> getUsersMenuItems(){
//        return this.usersMenuItems;
//    }
//
//    public void setUsersMenuItems(Set<UsersMenuItems> usersMenuItems) {
//        this.usersMenuItems = usersMenuItems;
//    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.users", cascade = CascadeType.ALL)
    public Set<UsersRestaurants> getUsersRestaurants(){

        return this.usersRestaurants;
    }

    public void setUsersRestaurants(Set<UsersRestaurants> usersRestaurants) {
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