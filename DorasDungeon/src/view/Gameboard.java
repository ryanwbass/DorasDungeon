package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * Created by Katie on 11/16/2015.
 */
public class Gameboard extends JPanel implements KeyListener {

    private boolean[][] gamePoints = new boolean[][]{
        {true,  true,   true,    true,    true,    true,    true,    true,    true,    true },
        {true,  true,   true,    true,    true,    true,    true,    true,    true,    true},
        {false, false,  false,   true,    true,    true,    false,   false,   false,   true},
        {true,  true,   false,   true,    true,    true,    false,   true,    false,   true},
        {true,  true,   false,   false,   false,   true,    false,   true,    false,   false},
        {true,  true,   true,    true,    false,   true,    false,   true,    true,    true},
        {true,  true,   true,    true,    false,   false,   false,   true,    true,    true},
        {true,  true,   true,    true,    true,    true,    true,    true,    true,    true},
        {true,  true,   true,    true,    true,    true,    true,    true,    true,    true},
        {true,  true,   true,    true,    true,    true,    true,    true,    true,    true}
    };

    private JLabel[][] gameLabels;

    private int playerPositionX;
    private int playerPositionY;

    final int rows = 10;
    final int cols = 10;

    private final int startCoordinateX = 0;
    private final int startCoordinateY = 2;

    private final int endCoordinateX = 9;
    private final int endCoordinateY = 4;

    public Gameboard() {


        this.gameLabels = new JLabel[rows][cols];

//        TODO: change size
        GridLayout gameGrid = new GridLayout(rows, cols, -1, -1);
        this.setLayout(gameGrid);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < cols; ++x) {
                JLabel n = new JLabel();
                n.setOpaque(true);
                if (y == 2 && x == 0) {
                    n.setBackground(Color.PINK);
                    playerPositionX = x;
                    playerPositionY = y;
                } else if (gamePoints[y][x]) {
                    n.setBackground(Color.DARK_GRAY);
                } else {
                    n.setBackground(Color.CYAN);
                }

                n.setBorder(BorderFactory.createLineBorder(Color.CYAN));
                gameLabels[y][x] = n;
                this.add(n);

            }
        }


        this.addKeyListener(this);
        this.setFocusable(true);
//        this.requestFocusInWindow();
    }

    private void atEnd() {

        if (playerPositionX == endCoordinateX && playerPositionY == endCoordinateY) {
            showGameOverMessage();
            restartGame();
        }

    }

    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    private void restartGame() {

        gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);
        gameLabels[startCoordinateY][startCoordinateX].setBackground(Color.PINK);

        playerPositionY = startCoordinateY;
        playerPositionX = startCoordinateX;

    }

    private void showGameOverMessage() {

        JFrame gameOver = new JFrame("Game Over!");
        JPanel panel = new JPanel();
        JLabel message = new JLabel("You won!");

        panel.setBackground(Color.DARK_GRAY);
        message.setBackground(Color.DARK_GRAY);
        message.setForeground(Color.CYAN);
        message.setFont(new Font("Arial", Font.PLAIN, 25));

        panel.add(message);

        gameOver.getContentPane().add(panel, "Center");

        gameOver.setBackground(Color.DARK_GRAY);
        gameOver.setSize(400, 100);
        gameOver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameOver.setVisible(true);

    }

    public void movePlayerRight() {

        // if the point to the right is not filled
        if (playerPositionX + 1 > 0 && playerPositionX + 1 < rows && !gamePoints[playerPositionY][playerPositionX + 1]) {
            // moves player one point to the right
            gameLabels[playerPositionY][playerPositionX + 1].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionX = playerPositionX + 1;  // only x coor changes

            atEnd();

        }

    }

    public void movePlayerLeft() {

        // if the point to the left is not filled
        if (playerPositionX - 1 >= 0 && playerPositionX - 1 < rows && !gamePoints[playerPositionY][playerPositionX - 1]) {
            // move player one point to the left
            gameLabels[playerPositionY][playerPositionX - 1].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionX = playerPositionX - 1;  // only x coor changes

            atEnd();

        }

    }

    public void movePlayerUp() {

        // if the point is not filled
        if (!gamePoints[playerPositionY - 1][playerPositionX]) {

            // move player one point up
            gameLabels[playerPositionY - 1][playerPositionX].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionY = playerPositionY - 1;  // only y coor changes

            atEnd();

        }

    }

    public void movePlayerDown() {

        // if the point is not filled
        if (!gamePoints[playerPositionY + 1][playerPositionX]) {

            // move player one point up
            gameLabels[playerPositionY + 1][playerPositionX].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionY = playerPositionY + 1;  // only y coor changes

            atEnd();

        }

    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
