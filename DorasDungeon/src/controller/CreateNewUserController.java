package com.company.controller;

import com.company.model.OptionsModel;
import com.company.model.User;
import com.company.model.UserList;
import com.company.view.CreateNewUserPanel;
import com.company.view.OptionsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/1/2015.
 */
public class CreateNewUserController {

    private CreateNewUserPanel view;
    private UserList model;

    public CreateNewUserController(CreateNewUserPanel view, UserList model) {
        this.view = view;
        this.model = model;

        view.addSubmitBtnListener(new SubmitNewUserListener());
        view.addReturnToMainMenuListener(new ReturnToMainMenuListener());

    }

    private class SubmitNewUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do work to create and add user to user list
            if (view.getFirstNameField().length() > 0 && view.getLastNameField().length() > 0) {

                model.addUser(new User(view.getFirstNameField(), view.getLastNameField()));
                System.out.println("New User Added");

                view.clearNameFields();
            }
        }
    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }
}
