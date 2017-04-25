//package edu.matc.entity;
//
//import javax.persistence.*;
//
//@Embeddable
//public class UsersRestaurantsID implements java.io.Serializable{
//
//    private Users users;
//    private Restaurants restaurants;
//
//    @ManyToOne
//    public Users getUsers() {
//        return users;
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }
//
//    @ManyToOne
//    public Restaurants getRestaurants() {
//        return restaurants;
//    }
//
//    public void setRestaurants(Restaurants restaurants) {
//        this.restaurants = restaurants;
//    }
//
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UsersRestaurantsID that = (UsersRestaurantsID) o;
//
//        if (users != null ? !users.equals(that.users) : that.users != null) return false;
//        if (restaurants != null ? !restaurants.equals(that.restaurants) : that.restaurants != null)
//            return false;
//
//        return true;
//    }
//
//    public int hashCode() {
//        int result;
//        result = (users != null ? users.hashCode() : 0);
//        result = 31 * result + (restaurants != null ? restaurants.hashCode() : 0);
//        return result;
//    }
//}
