package view;

import javafx.scene.layout.HBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Katie on 11/11/2015.
 */
public class GameOptionView extends JPanel {

    private final MyJPanel parentPanel;
    private Gameboard gameboard;
    public OptionButton returnToMain;

    private JLabel playerScoreLabel;
    private int playerScore;

    //, moveLeft, moveRight, moveDown, moveUp
    public GameOptionView(MyJPanel parentPanel) {

        playerScore = 0;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

        this.parentPanel = parentPanel;

        gameboard = new Gameboard(this);
        this.add(gameboard, BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();

        returnToMain = new OptionButton();
        returnToMain.setText("Return to Options");
        box.add(returnToMain);

        box.add(Box.createHorizontalStrut(850));

        playerScoreLabel = new JLabel("Player Score:  00");
        playerScoreLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
        playerScoreLabel.setForeground(Color.CYAN);
        box.add(playerScoreLabel);

        this.add(box, BorderLayout.SOUTH);


        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
        this.getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGameboard().movePlayerUp();
            }
        });

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
        this.getActionMap().put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGameboard().movePlayerDown();
            }
        });

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
        this.getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGameboard().movePlayerRight();
            }
        });

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
        this.getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGameboard().movePlayerLeft();
            }
        });

    }

    public Gameboard getGameboard() {
        return gameboard;
    }

    public void addReturnToMainMenuBtnListener(ActionListener action) {
        returnToMain.addActionListener(action);
    }

    public void incrementPlayerScore() {

        playerScore ++;

        playerScoreLabel.setText(String.format(
                "Player Score: %d",
                playerScore
        ));

    }

    public void resetPlayerScore() {
        playerScore = 0;

        playerScoreLabel.setText(String.format(
                "Player Score: %d",
                playerScore
        ));

    }

}
