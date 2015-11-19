package view;

import javafx.scene.layout.HBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/11/2015.
 */
public class GameOptionView extends JPanel {

    private final MyJPanel parentPanel;
    private Gameboard gameboard;
    public OptionButton returnToMain, moveLeft, moveRight, moveDown, moveUp;

    public GameOptionView(MyJPanel parentPanel) {

        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

        this.parentPanel = parentPanel;

        gameboard = new Gameboard();
        this.add(gameboard, BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();

        returnToMain = new OptionButton();
        returnToMain.setText("Return to Options");
        box.add(returnToMain);

        moveLeft = new OptionButton();
        moveLeft.setText("<");
        box.add(moveLeft);

        moveRight = new OptionButton();
        moveRight.setText(">");
        box.add(moveRight);

        moveDown = new OptionButton();
        moveDown.setText("v");
        box.add(moveDown);

        moveUp = new OptionButton();
        moveUp.setText("^");
        box.add(moveUp);

        this.add(box, BorderLayout.SOUTH);

    }

    public Gameboard getGameboard() {
        return gameboard;
    }

    public void addReturnToMainMenuBtnListener(ActionListener action) {
        returnToMain.addActionListener(action);
    }

    public void addMoveLeftBtnListener(ActionListener action) {
        moveLeft.addActionListener(action);
    }

    public void addMoveRightBtnListener(ActionListener action) {
        moveRight.addActionListener(action);
    }

    public void addMoveUpBtnListener(ActionListener action) {
        moveUp.addActionListener(action);
    }

    public void addMoveDownBtnListener(ActionListener action) {
        moveDown.addActionListener(action);
    }

}
