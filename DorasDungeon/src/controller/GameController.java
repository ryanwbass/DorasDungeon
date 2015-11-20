package controller;

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
//        gameOptionView.addMoveLeftBtnListener(new MoveLeftListener());
//        gameOptionView.addMoveRightBtnListener(new MoveRightListener());
//        gameOptionView.addMoveUpBtnListener(new MoveUpListener());
//        gameOptionView.addMoveDownBtnListener(new MoveDownListener());

    }

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Working");
            parentPanel.clearTopPanel(gameOptionView);
            parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
        }
    }


//    private class MoveLeftListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            gameOptionView.getGameboard().movePlayerLeft();
//        }
//    }
//
//    private class MoveRightListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            gameOptionView.getGameboard().movePlayerRight();
//        }
//    }
//
//    private class MoveUpListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            gameOptionView.getGameboard().movePlayerUp();
//        }
//    }
//
//
//    private class MoveDownListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            gameOptionView.getGameboard().movePlayerDown();
//        }
//    }
}
