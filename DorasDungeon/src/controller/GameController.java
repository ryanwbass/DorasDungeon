package controller;

import view.GameOptionView;
import view.MyJPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

    private GameOptionView gameboard;
    private MyJPanel parentPanel;

    public GameController(GameOptionView gameboard, MyJPanel parentPanel) {

        this.gameboard = gameboard;
        this.parentPanel = parentPanel;
        gameboard.addReturnToMainMenuBtnListener(new ReturnToMainMenuListener());

    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Working");
            parentPanel.clearTopPanel(gameboard);
            parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
        }
    }
}
