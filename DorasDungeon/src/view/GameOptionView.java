package view;

import model.GameDifficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Katie on 11/11/2015.
 */
public class GameOptionView extends JPanel {

    private final MyJPanel parentPanel;
    private Gameboard gameboard;
    public OptionButton returnToMain;

    private JLabel timeLabel;
    private JLabel playerScoreLabel;
    private int playerScore;
    private int gameTurns;
    private GameDifficulty gameDifficulty;

    public GameOptionView(MyJPanel parentPanel, GameDifficulty gameDifficulty) {

        this.gameDifficulty = gameDifficulty;
        gameTurns = gameDifficulty.getTurns();
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

        box.add(Box.createHorizontalStrut(400));
        
        timeLabel = new JLabel(String.format(
                "Turns Left: %d",
                gameTurns));
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

        gameTurns --;
        
        timeLabel.setText(String.format(
                "Turns Left: %d",
                gameTurns
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
        gameTurns = gameDifficulty.getTurns();

        timeLabel.setText(String.format(
                "Turns Left: %d",
                gameTurns
        ));

    }
    
    public int getRemainingTurns()
    {
        return gameTurns;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }
}
