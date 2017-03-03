package edu.matc.entity;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class restaurants {

    @Column(name = "restaurantName")
    private String restaurantName;

    public restaurants() {
    }

    public restaurants(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '}';
    }
}
