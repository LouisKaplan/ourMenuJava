package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usersRestaurants", catalog = "ourMenu")
@AssociationOverrides({
        @AssociationOverride(name = "pk.users",
            joinColumns = @JoinColumn(name="userName")),
        @AssociationOverride(name = "pk.restaurants",
            joinColumns = @JoinColumn(name="restaurantName")),
})
public class UsersRestaurants implements java.io.Serializable {

    private UsersRestaurantsID pk = new UsersRestaurantsID();
    private int userRating;

//    private int linkID;
//    private Users userID;
//    private Restaurants restaurantName;
//    private int restaurantRating;

    public UsersRestaurants(){
    }

    @EmbeddedId
    public UsersRestaurantsID getPK(){
        return pk;
    }

    public void setPK (UsersRestaurantsID pk){
        this.pk = pk;
    }

    @Transient
    public Users getUsers(){
        return getPK().getUsers();
    }

    public void setUsers(Users users){
        getPK().setUsers(users);
    }

    @Transient
    public Restaurants getRestaurants(){
        return getPK().getRestaurants();
    }

    public void setRestaurants(Restaurants restaurants){
        getPK().setRestaurants(restaurants);
    }

    @Column(name = "userRating", length = 11)
    public int getUserRating() {
        return this.userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UsersRestaurants that = (UsersRestaurants) o;

        if (getPK() != null ? !getPK().equals(that.getPK())
                : that.getPK() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPK() != null ? getPK().hashCode() : 0);
    }



//    @Id
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    @Column(name = "linkID")
//    public int getLinkID() {
//        return linkID;
//    }
//
//    public void setLinkID(int linkID) {
//        this.linkID = linkID;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "userID")
//    public Users getUserID() {
//        return userID;
//    }
//
//    public void setUserID(Users userID) {
//        this.userID = userID;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurantName")
//    public Restaurants getRestaurantName() {
//        return restaurantName;
//    }
//
//    public void setRestaurantName(Restaurants restaurantName) {
//        this.restaurantName = restaurantName;
//    }
//
//    @Column(name = "restaurantRating")
//    public int getRestaurantRating() {
//        return restaurantRating;
//    }
//
//    public void setRestaurantRating(int restaurantRating) {
//        this.restaurantRating = restaurantRating;
//    }

}