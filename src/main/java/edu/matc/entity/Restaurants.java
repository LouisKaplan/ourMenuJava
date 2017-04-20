package edu.matc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="restaurants")
public class Restaurants implements Serializable{

    private String restaurantName;
    private String restaurantType;
    private Set<UsersRestaurants> usersRestaurants = new HashSet<UsersRestaurants>(0);

    public Restaurants() {
    }

    public Restaurants(String restaurantName,
                       String restaurantType) {
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
    }

    public Restaurants(String restaurantName,
                       String restaurantType,
                       Set<UsersRestaurants> usersRestaurants) {
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.usersRestaurants = usersRestaurants;
    }

    @Id
    @Column(name = "restaurantName")
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Column(name = "restaurantType")
    public String getRestaurantType() { return restaurantType; }

    public void setRestaurantType(String restaurantType) { this.restaurantType = restaurantType; }



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.restaurants")
    public Set<UsersRestaurants> getUsersRestaurants(){
        return this.usersRestaurants;
    }

    public void setUsersRestaurants(Set<UsersRestaurants> usersRestaurants) {
        this.usersRestaurants = usersRestaurants;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurantName", cascade = CascadeType.ALL)
//    public Set<UsersRestaurants> getUsersRestaurants(){
//        return this.usersRestaurants;
//    }
//
//    public void setUsersRestaurants(Set<UsersRestaurants> user) {
//        this.usersRestaurants = usersRestaurants;
//    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName +
                "restaurantType='" + restaurantType + '}';
    }
}
