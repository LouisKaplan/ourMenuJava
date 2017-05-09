package edu.matc.entity;

import javax.persistence.*;



@Entity
@Table(name="restaurants")
public class Restaurants implements java.io.Serializable {

    @Id
    @Column(name = "restaurantName")
    private String restaurantName;

    @Column(name = "restaurantType")
    private String restaurantType;


    public Restaurants() {
    }


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

}