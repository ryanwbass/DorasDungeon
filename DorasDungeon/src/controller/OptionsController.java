package controller;

import com.company.model.GameDifficulty;
import com.company.model.OptionsModel;
import com.company.model.UserList;
import com.company.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    // add inner classes to link view to model

    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do stuff to start the game
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

            view.dispose();

        }
    }

}
