package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="usersMenuItems")
public class UsersMenuItems {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "userItemID")
    private int userItemID;

    public int getUserItemID() {
        return userItemID;
    }

    public void setUserItemID(int userItemID) {
        this.userItemID = userItemID;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userName")
    private Users userName;

    public Users getUserName() {
        return userName;
    }

    public void setUserName(Users userName) {
        this.userName = userName;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuItemID")
    private MenuItems menuItemID;

    public MenuItems getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(MenuItems menuItemID) {
        this.menuItemID = menuItemID;
    }

}