package controller;

import model.GameDifficulty;
import view.GameOptionView;
import view.MyJPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

    private GameOptionView gameOptionView;
    private MyJPanel parentPanel;

    public GameController(GameOptionView gameboard, MyJPanel parentPanel) {

        this.gameOptionView = gameboard;
        this.parentPanel = parentPanel;
        gameOptionView.addReturnToMainMenuBtnListener(new ReturnToMainMenuListener());

    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Working");
            parentPanel.clearTopPanel(gameOptionView);
            parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
        }
    }

}
