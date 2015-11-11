package view;

import model.GameDifficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/3/2015.
 */
public class SetDifficultyView extends JFrame {

    private GameDifficulty model;
    private JSlider slider;

    private JButton returnToMainMenu, setNewDifficulty;

    public SetDifficultyView(GameDifficulty model) {
        this.model = model;

        JPanel panel = new JPanel();

        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.setMargin(new Insets(10, 10, 10, 10));
        returnToMainMenu.setBackground(Color.DARK_GRAY);
        returnToMainMenu.setForeground(Color.CYAN);
        returnToMainMenu.setFont(new Font("Ariel", Font.PLAIN, 20));
        returnToMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(returnToMainMenu);

        // JSlider should go here
        panel.add(Box.createVerticalStrut(20));
        slider = new JSlider(JSlider.HORIZONTAL, 1, 3, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setForeground(Color.CYAN);
        slider.setBackground(Color.DARK_GRAY);
        slider.setFont(new Font("Ariel", Font.ITALIC, 15));
        panel.add(slider);
        panel.add(Box.createVerticalStrut(20));

        setNewDifficulty = new JButton("Set Difficulty");
        setNewDifficulty.setMargin(new Insets(10, 10, 10, 10));
        setNewDifficulty.setBackground(Color.DARK_GRAY);
        setNewDifficulty.setForeground(Color.CYAN);
        setNewDifficulty.setFont(new Font("Ariel", Font.PLAIN, 20));
        setNewDifficulty.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(setNewDifficulty);

        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
        this.setTitle("Remove Selected User");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void addReturnToMainMenuListener(ActionListener action) {
        returnToMainMenu.addActionListener(action);
    }

    public void addSetNewDifficultyListener(ActionListener action) {
        setNewDifficulty.addActionListener(action);
    }

    public JSlider getSlider() {
        return slider;
    }
}
