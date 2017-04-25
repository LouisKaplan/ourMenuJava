package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="usersRestaurants")

public class UsersRestaurants {


    private int userRestID;
    private Users users;
    private Restaurants restaurants;
    private int userRating;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "userRestID")
    public int getUserRestID() {
        return userRestID;
    }

    public void setUserRestID(int userRestID) {
        this.userRestID = userRestID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userName")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantName")
    public Restaurants getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }

    @Column(name = "userRating")
    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}