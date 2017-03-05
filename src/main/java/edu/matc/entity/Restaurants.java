package edu.matc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="restaurants")
public class Restaurants implements Serializable{

    @Id
    @Column(name = "restaurantName")
    private String restaurantName;

    @Column(name = "restaurantType")
    private String restaurantType;

    public Restaurants() {
    }

    public Restaurants(String restaurantName,
                       String restaurantType) {
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantType() { return restaurantType; }

    public void setRestaurantType(String restaurantType) { this.restaurantType = restaurantType; }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName +
                "restaurantType='" + restaurantType + '}';
    }
}
