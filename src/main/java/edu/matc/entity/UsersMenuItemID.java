package edu.matc.entity;

import javax.persistence.*;

@Embeddable
public class UsersMenuItemID implements java.io.Serializable{

    private Users users;
    private MenuItems menuItems;

    @ManyToOne
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne
    public MenuItems getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItems menuItems) {
        this.menuItems = menuItems;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersMenuItemID that = (UsersMenuItemID) o;

        if (users != null ? !users.equals(that.users) : that.users != null) return false;
        if (menuItems != null ? !menuItems.equals(that.menuItems) : that.menuItems != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (users != null ? users.hashCode() : 0);
        result = 31 * result + (menuItems != null ? menuItems.hashCode() : 0);
        return result;
    }

}
