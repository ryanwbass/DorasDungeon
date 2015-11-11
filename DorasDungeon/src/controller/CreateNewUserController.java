package controller;

import java.awt.BorderLayout;
import model.OptionsModel;
import model.User;
import model.UserList;
import view.CreateNewUserPanel;
import view.OptionsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MyJPanel;

/**
 * Created by Katie on 11/1/2015.
 */
public class CreateNewUserController {

    private CreateNewUserPanel view;
    private UserList userList;
    
    private MyJPanel parentPanel;

    public CreateNewUserController(CreateNewUserPanel view, UserList userList, MyJPanel parentPanel) {
        this.view = view;
        this.userList = userList;
        
        this.parentPanel = parentPanel;

        view.addSubmitBtnListener(new SubmitNewUserListener());
        view.addReturnToMainMenuListener(new ReturnToMainMenuListener());

    }

    private class SubmitNewUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do work to create and add user to user list
            if (view.getFirstNameField().length() > 0 && view.getLastNameField().length() > 0) {

                userList.addUser(new User(view.getFirstNameField(), view.getLastNameField()));
                System.out.println("New User Added");

                view.clearNameFields();
            }
        }
    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            parentPanel.clearTopPanel(view);
           
            
            parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
           
        }
    }
}
