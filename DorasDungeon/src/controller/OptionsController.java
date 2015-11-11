package controller;

import model.OptionsModel;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameDifficulty;
import model.UserList;

/**
 * Created by Katie on 10/30/2015.
 */
public class OptionsController {

    private OptionsView view;
    private OptionsModel model;
    private UserList userList;
    private GameDifficulty difficultySetting;

    public OptionsController(OptionsView view, OptionsModel model) {
        this.view = view;
        this.model = model;

        userList = new UserList();
        difficultySetting = new GameDifficulty();

        // add action listeners to buttons
        view.addStartGameBtnListener(new StartGameListener());
        view.addNewUserBtnListener(new AddNewUserListener());
        view.addRemoveUserBtnListener(new RemoveUserListener());
        view.addSetDifficultyBtnListener(new SetDifficultyListener());
        view.addQuitGameBtnListener(new QuitGameListener());

    }   

    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do stuff to start the game
            System.out.println("Clickity");
            StartGameFrame frame = new StartGameFrame();

            frame.setVisible(true);

        }
    }

    private class AddNewUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateNewUserPanel newView = new CreateNewUserPanel(userList);
            CreateNewUserController newController = new CreateNewUserController(newView, userList);
            newView.setVisible(true);
        }
    }

    private class RemoveUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveUserListView newView = new RemoveUserListView(userList);
            RemoveUserController newController = new RemoveUserController(newView, userList);
            newView.setVisible(true);
        }
    }

    private class SetDifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do stuff to set the difficulty

            SetDifficultyView newView = new SetDifficultyView(difficultySetting);
            SetGameDifficultyController newController = new SetGameDifficultyController(newView, difficultySetting);

            newView.setVisible(true);

        }
    }

    private class QuitGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
            topFrame.dispose();

        }
    }

}
