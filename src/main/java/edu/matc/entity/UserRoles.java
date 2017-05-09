package edu.matc.entity;


import javax.persistence.*;

@Entity
@Table(name="userRoles")
public class UserRoles implements java.io.Serializable{

    @Id
    @Column(name = "userName")
    private String userName;

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

    public void setUserName(String userName){
        this.userName = userName;
    }


    public String getUserRole(){
        return this.userRole;
    }

    public void setUserRole(String userRole){
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
