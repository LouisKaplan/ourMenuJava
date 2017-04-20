//package edu.matc.entity;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name="usersMenuItem")
//public class UsersMenuItems implements Serializable {
//
//    private int joinID;
//    private Users userID;
//    private MenuItems menuItemID;
//
//    @Id
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    @Column(name = "joinID")
//    public int getJoinID() {
//        return joinID;
//    }
//
//    public void setJoinID(int joinID) {
//        this.joinID = joinID;
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
//    @JoinColumn(name = "menuItemID")
//    public MenuItems getMenuItemID() {
//        return menuItemID;
//    }
//
//    public void setMenuItemID(MenuItems menuItemID) {
//        this.menuItemID = menuItemID;
//    }
//
//}