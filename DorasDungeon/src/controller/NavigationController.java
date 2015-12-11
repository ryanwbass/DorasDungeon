package controller;

import java.awt.BorderLayout;
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
public class NavigationController {
// etucd
    private OptionsView view;
    private OptionsModel model;
    private UserList userList;
    private GameDifficulty difficultySetting;
    
    private String mostRecentOptionChange;
    
    private MyJPanel parentPanel;

    public NavigationController(OptionsView view, OptionsModel model, MyJPanel parentPanel) {
        this.view = view;
        this.model = model;

        this.parentPanel = parentPanel;
        
        userList = new UserList();
        difficultySetting = new GameDifficulty();

        // add action listeners to buttons
        view.addStartGameBtnListener(new StartGameListener());
        view.addNewUserBtnListener(new AddNewUserListener());
        view.addRemoveUserBtnListener(new RemoveUserListener());
        view.addSetDifficultyBtnListener(new SetDifficultyListener());
        view.addQuitGameBtnListener(new QuitGameListener());

    }   

    public String getMostRecentOptionChange() {
        return mostRecentOptionChange;
        // this is a test
    }
    
    public void setMostRecentOptionChange(String option) {
        mostRecentOptionChange = option;
    }

    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do stuff to start the game
            parentPanel.clearTopPanel(view);

            GameOptionView gameboard = new GameOptionView(parentPanel);
            GameController gameboardController = new GameController(gameboard, parentPanel);

            parentPanel.add(gameboard, BorderLayout.CENTER);
          
        }
    }

    private class AddNewUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            parentPanel.clearTopPanel(view);
            CreateNewUserPanel newView = new CreateNewUserPanel(userList);
            CreateNewUserController newController = new CreateNewUserController(newView, userList, parentPanel);
            parentPanel.add(newView, BorderLayout.CENTER);
        }
    }

    private class RemoveUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parentPanel.clearTopPanel(view);
            RemoveUserListView newView = new RemoveUserListView(userList);
            RemoveUserController newController = new RemoveUserController(newView, userList, parentPanel);
            parentPanel.add(newView, BorderLayout.CENTER);
        }
    }

    private class SetDifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do stuff to set the difficulty
            parentPanel.clearTopPanel(view);

            SetDifficultyView newView = new SetDifficultyView(difficultySetting);
            SetGameDifficultyController newController = new SetGameDifficultyController(newView, difficultySetting, parentPanel);

            parentPanel.add(newView, BorderLayout.CENTER);

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
