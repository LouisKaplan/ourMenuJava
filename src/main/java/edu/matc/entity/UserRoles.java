package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="userRoles")
public class UserRoles implements java.io.Serializable{

    @Id
    @Column(name = "userName")
    private String userName;

    @Id
    @Column(name = "userRole")
    private String userRole;

    public UserRoles(){
    }

    public UserRoles(String userName,
                     String userRole){
        this.userName = userName;
        this.userRole = userRole;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(){
        this.userName = userName;
    }


    public String getUserRole(){
        return this.userRole;
    }

    public void setUserRole(){
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "userName=" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
