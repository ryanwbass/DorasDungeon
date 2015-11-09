package com.company.controller;

import com.company.model.User;
import com.company.model.UserList;
import com.company.view.RemoveUserListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/3/2015.
 */
public class RemoveUserController {

    private RemoveUserListView view;
    private UserList model;

    public RemoveUserController(RemoveUserListView view, UserList model) {
        this.view = view;
        this.model = model;

        view.AddReturnToMainMenuListener(new ReturnToMainMenuListener());
        view.AddDeleteUserListener(new DeleteUserListener());
    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }


    private class DeleteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // use model to delte user
            System.out.println("Working");

            User selectedUser = (User) view.getUserJList().getSelectedValue();
            if (selectedUser != null) {
                model.removeUser(selectedUser);
            }
        }
    }
}
