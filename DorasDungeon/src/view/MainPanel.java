/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Katie
 */
public class MainPanel extends JPanel{
    JButton splashButton;
    JLabel optionsLabel;
    public MainPanel()
    {
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createVerticalStrut(50));
        splashButton = new JButton(new ImageIcon("src/images/doras_dungeon.jpg"));
        splashButton.setAlignmentX(CENTER_ALIGNMENT);
        add(splashButton);
        add(Box.createVerticalStrut(30));

        optionsLabel = new JLabel("No options selected yet.");
        optionsLabel.setForeground(Color.CYAN);
        optionsLabel.setFont(new Font("Ariel", Font.PLAIN, 20));
        optionsLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(optionsLabel);

    }
}
