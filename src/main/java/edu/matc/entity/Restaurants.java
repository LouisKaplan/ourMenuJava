package edu.matc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="restaurants")
public class Restaurants implements java.io.Serializable {

    @Id
    @Column(name = "restaurantName")
    private String restaurantName;

    @Column(name = "restaurantType")
    private String restaurantType;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.restaurants")
//    private Set<UsersRestaurants> usersRestaurants = new HashSet<UsersRestaurants>(0);

    public Restaurants() {
    }

    public Restaurants(String restaurantName,
                       String restaurantType) {
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
    }

//    public Restaurants(String restaurantName,
//                       String restaurantType,
//                       Set<UsersRestaurants> usersRestaurants) {
//        this.restaurantName = restaurantName;
//        this.restaurantType = restaurantType;
//        this.usersRestaurants = usersRestaurants;
//    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }


    public String getRestaurantType() {
        return this.restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }


//    public Set<UsersRestaurants> getUsersRestaurants() {
//        return this.usersRestaurants;
//    }
//
//    public void setUsersRestaurants(Set<UsersRestaurants> usersRestaurants) {
//        this.usersRestaurants = usersRestaurants;
//    }
}