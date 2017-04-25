package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="usersRestaurants")
public class UsersRestaurants {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "userRestID")
    private int userRestID;

    public int getUserRestID() {
        return userRestID;
    }

    public void setUserRestID(int userRestID) {
        this.userRestID = userRestID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userName")
    private Users userName;

    public Users getUsers() {
        return userName;
    }

    public void setUsers(Users userName) {
        this.userName = userName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantName")
    private Restaurants restaurantName;

    public Restaurants getRestaurants() {
        return restaurantName;
    }

    public void setRestaurants(Restaurants restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Column(name = "userRating")
    private int userRating;

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}