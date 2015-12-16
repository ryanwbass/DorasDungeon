package view;

import javafx.scene.layout.HBox;
import model.GameDifficulty;

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
    private GameDifficulty diff;

    private JLabel timeLabel;
    private JLabel playerScoreLabel;
    private int playerScore;
    private int turns;

    //, moveLeft, moveRight, moveDown, moveUp
    public GameOptionView(MyJPanel parentPanel) {
        
       //So far only does the default setting. Needs to work with the difficulty slider.
       diff = new GameDifficulty();
       playerScore = 0;
      
       turns = diff.getTurns();
       
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

        this.parentPanel = parentPanel;

        gameboard = new Gameboard(this);
        this.add(gameboard, BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();

        returnToMain = new OptionButton();
        returnToMain.setText("Return to Options");
        box.add(returnToMain);

        box.add(Box.createHorizontalStrut(400));
        
        timeLabel = new JLabel(String.format(
                "Turns Left: %d",
                turns));
        timeLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
        timeLabel.setForeground(Color.CYAN);
        box.add(timeLabel);
        
        box.add(Box.createHorizontalStrut(425));

        playerScoreLabel = new JLabel("Player Score:  0");
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

    public void decrementTurns() {
        
        turns --;
        
        timeLabel.setText(String.format(
                "Turns Left: %d",
                turns
        ));

    }
    public void resetPlayerScore() {
        playerScore = 0;

        playerScoreLabel.setText(String.format(
                "Player Score: %d",
                playerScore
        ));

    }
    
    public void resetTurns() {
        turns = diff.getTurns();

        timeLabel.setText(String.format(
                "Turns Left: %d",
                turns
        ));

    }
    
    public int getRemainingTurns()
    {
        return turns;
    }

}
