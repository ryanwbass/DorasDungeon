package controller;

import com.company.model.GameDifficulty;
import com.company.view.SetDifficultyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/3/2015.
 */
public class SetGameDifficultyController {

    private SetDifficultyView view;
    private GameDifficulty model;

    public SetGameDifficultyController(SetDifficultyView view, GameDifficulty model) {
        this.view = view;
        this.model = model;

        this.view.addReturnToMainMenuListener(new ReturnToMainMenuListener());
        this.view.addSetNewDifficultyListener(new SetNewDifficultyListener());
    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }

    private class SetNewDifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setDifficulty(view.getSlider().getValue());
        }
    }
}
