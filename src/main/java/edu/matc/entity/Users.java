package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class Users implements Serializable{

    @ElementCollection
    private Set<UsersMenuItem> usersMenuItem = new HashSet<UsersMenuItem>(0);

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "userID")
    private int userid;

    @Column(name = "userFirstName")
    private String firstName;

    @Column(name = "userLastName")
    private String lastName;

    @Column(name = "userRole")
    private String userRole;

    @Column(name = "userPassword")
    private String userPassword;

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

    public Users(String firstName,
                 String lastName,
                 String userRole,
                 String userPassword,
                 Set<UsersMenuItem> usersMenuItem) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.userPassword = userPassword;
        this.usersMenuItem = usersMenuItem;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.users", cascade=CascadeType.ALL)
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