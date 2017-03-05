package edu.matc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usersMenuItem")
@AssociationOverrides({
    @AssociationOverride(name = "pk.users", joinColumns = @JoinColumn(name = "userID")),
    @AssociationOverride(name = "pk.menuItems", joinColumns = @JoinColumn(name = "menuItemID"))
    })

public class UsersMenuItem implements Serializable{

    private UsersMenuItemID pk = new UsersMenuItemID();
    private boolean wantsItem;

    public UsersMenuItem() {
    }

    @EmbeddedId
    public UsersMenuItemID getPk() {
        return pk;
    }

    public void setPk(UsersMenuItemID pk) {
        this.pk = pk;
    }

    @Transient
    public Users getUsers() {
        return getPk().getUsers();
    }

    public void setUsers(Users users) {
        getPk().setUsers(users);
    }

    @Transient
    public MenuItems getMenuItems() {
        return getPk().getMenuItems();
    }

    public void setMenuItems(MenuItems menuItems) {
        getPk().setMenuItems(menuItems);
    }

    @Column(name = "wantsItem")
    public boolean getWantsItem() {
        return this.wantsItem;
    }

    public void setWantsItem(boolean wantsItem) {
        this.wantsItem = wantsItem;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UsersMenuItem that = (UsersMenuItem) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}