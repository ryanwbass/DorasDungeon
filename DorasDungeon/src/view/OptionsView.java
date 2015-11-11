package view;

import model.OptionsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katie on 10/30/2015.
 */
public class OptionsView extends JPanel {

//    Five Buttons:
    private OptionButton startGameBtn;
    private OptionButton newUserBtn;
    private OptionButton removeUserBtn;
    private OptionButton setDifficultyBtn;
    private OptionButton quitGameBtn;

    private List<OptionButton> btnList;

    private OptionsModel model;

    public OptionsView(OptionsModel model) {
        this.model = model;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.DARK_GRAY);

        // add title label to view

        JLabel titleLabel = new JLabel("Dora's Dungeon");
        titleLabel.setFont(new Font("Ariel", Font.PLAIN, 40));
        titleLabel.setBackground(Color.DARK_GRAY);
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titleLabel);
        this.add(Box.createVerticalStrut(30));

        // set up Btns on View

        btnList = new ArrayList<>();
        btnList.add(startGameBtn = new OptionButton());
        btnList.add(newUserBtn = new OptionButton());
        btnList.add(removeUserBtn = new OptionButton());
        btnList.add(setDifficultyBtn = new OptionButton());
        btnList.add(quitGameBtn = new OptionButton());

        for (int i = 0; i < btnList.size(); ++i) {
            btnList.get(i).setText(model.getOptions().get(i));
            this.add(btnList.get(i));
            this.add(Box.createVerticalStrut(20));
        }
    }

    public void addStartGameBtnListener(ActionListener action) {
        startGameBtn.addActionListener(action);
    }

    public void addNewUserBtnListener(ActionListener action) {
        newUserBtn.addActionListener(action);
    }

    public void addRemoveUserBtnListener(ActionListener action) {
        removeUserBtn.addActionListener(action);
    }

    public void addSetDifficultyBtnListener(ActionListener action) {
        setDifficultyBtn.addActionListener(action);
    }

    public void addQuitGameBtnListener(ActionListener action) {
        quitGameBtn.addActionListener(action);
    }

}
