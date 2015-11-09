package com.company.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katie on 11/1/2015.
 */
public class UserList {

    private DefaultListModel<User> users;

    public UserList() {
        users = new DefaultListModel<>();
    }

    public DefaultListModel getUsers() {
        return users;
    }

    public void addUser(User u) {
        if (!users.contains(u)) {
            users.add(0, u);
        }
    }

    public void removeUser(User u) {
            users.removeElement(u);
    }

    public int numUsers() {
        return users.size();
    }

    public boolean hasUser(User u) {
        return users.contains(u);
    }


}
