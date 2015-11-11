package controller;

import java.awt.BorderLayout;
import model.User;
import model.UserList;
import view.RemoveUserListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.OptionsModel;
import view.MyJPanel;
import view.OptionsView;

/**
 * Created by Katie on 11/3/2015.
 */
public class RemoveUserController {

    private RemoveUserListView view;
    private UserList userList;

    private MyJPanel parentPanel;
    
    public RemoveUserController(RemoveUserListView view, UserList userList, MyJPanel parentPanel) {
        this.view = view;
        this.userList = userList;
        
        this.parentPanel = parentPanel;

        view.AddReturnToMainMenuListener(new ReturnToMainMenuListener());
        view.AddDeleteUserListener(new DeleteUserListener());
    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parentPanel.clearTopPanel(view);
            
            parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
        }
    }


    private class DeleteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // use model to delte user
            System.out.println("Working");

            User selectedUser = (User) view.getUserJList().getSelectedValue();
            if (selectedUser != null) {
                userList.removeUser(selectedUser);
            }
        }
    }
}
