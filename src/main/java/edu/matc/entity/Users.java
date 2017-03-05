package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class Users implements Serializable{

    private int userid;
    private String firstName;
    private String lastName;
    private String userRole;
    private String userPassword;
    private Set<UsersMenuItem> usersMenuItem = new HashSet<UsersMenuItem>(0);

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "userID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "userFirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "userLastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "userRole")
    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Column(name = "userPassword")
    public String getUserPassword(){
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Users() {
    }

    public Users(String firstName,
                 String lastName,
                 String userRole,
                 String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.userPassword = userPassword;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.users")
    public Set<UsersMenuItem> getUsersMenuItem(){
        return this.usersMenuItem;
    }

    public void setUsersMenuItem(Set<UsersMenuItem> usersMenuItem) {
        this.usersMenuItem = usersMenuItem;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userRole=" + userRole + '\'' +
                ", userPassword=" + userPassword + '\'' +
                '}';
    }
}