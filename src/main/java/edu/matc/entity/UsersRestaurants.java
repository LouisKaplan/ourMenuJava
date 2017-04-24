package edu.matc.entity;

import javax.persistence.*;

@Entity
@Table(name="usersRestaurants")
@AssociationOverrides({
        @AssociationOverride(name = "pk.users",
            joinColumns = @JoinColumn(name = "userName")),
        @AssociationOverride(name = "pk.restaurants",
            joinColumns = @JoinColumn(name = "restaurantName")) })

public class UsersRestaurants implements java.io.Serializable {

    public UsersRestaurants(){
    }

    @EmbeddedId
    private UsersRestaurantsID pk = new UsersRestaurantsID();

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

    @Column(name = "userRating")
    private int userRating;
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

}