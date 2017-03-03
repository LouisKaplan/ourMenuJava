package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class users {

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

    public users() {
    }

    public users(String firstName,
                 String lastName,
                 int userid,
                 String userRole,
                 String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.userRole = userRole;
        this.userPassword = userPassword;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid=" + userid + '\'' +
                ", userRole=" + userRole + '\'' +
                ", userPassword=" + userPassword + '\'' +
                '}';
    }
}