package controller;

import java.awt.BorderLayout;
import model.GameDifficulty;
import view.SetDifficultyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MyJPanel;

/**
 * Created by Katie on 11/3/2015.
 */
public class SetGameDifficultyController {

    private SetDifficultyView view;
    private GameDifficulty model;
    
    private MyJPanel parentPanel;

    public SetGameDifficultyController(SetDifficultyView view, GameDifficulty model, MyJPanel parentPanel) {
        this.view = view;
        this.model = model;
        
        this.parentPanel = parentPanel;

        this.view.addReturnToMainMenuListener(new ReturnToMainMenuListener());
        this.view.addSetNewDifficultyListener(new SetNewDifficultyListener());
    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            parentPanel.clearTopPanel(view);
            
            parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
            
        }
    }

    private class SetNewDifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setDifficulty(view.getSlider().getValue());
            parentPanel.optionsController.setMostRecentOptionChange(String.format("Difficulty set to %d", model.getDifficulty()));
        }
    }
}
