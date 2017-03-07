package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usersRestaurants")
public class UsersRestaurants implements Serializable {

    private int linkID;
    private Users userID;
    private Restaurants restaurantName;
    private int restaurantRating;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "linkID")
    public int getLinkID() {
        return linkID;
    }

    public void setLinkID(int linkID) {
        this.linkID = linkID;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantName")
    public Restaurants getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(Restaurants restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Column(name = "restaurantRating")
    public int getRestaurantRating() {
        return restaurantRating;
    }

    public void setRestaurantRating(int restaurantRating) {
        this.restaurantRating = restaurantRating;
    }

}