package edu.matc.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userName")
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