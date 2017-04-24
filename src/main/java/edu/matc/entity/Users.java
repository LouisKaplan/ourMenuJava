package edu.matc.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "userName")
})
public class Users implements java.io.Serializable{

    @Id
    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "userPassword")
    private String userPassword;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usersMenuItems", joinColumns = {
            @JoinColumn(name = "userName")},
        inverseJoinColumns = { @JoinColumn(name = "menuItemID") })
    private Set<MenuItems> menuItems = new HashSet<MenuItems>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.users", cascade = CascadeType.ALL)
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
        this.usersRestaurants = usersRestaurants;
        this.userName = userName;
        this.displayName = displayName;
        this.userPassword = userPassword;

    }

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


    public Set<MenuItems> getMenuItems(){
        return this.menuItems;
    }

    public void setMenuItems(Set<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }


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