/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        
        splashButton = new JButton(new ImageIcon("src/images/doras_dungeon.jpg"));            
        add(splashButton);

        optionsLabel = new JLabel("No options selected yet.");
        optionsLabel.setForeground(Color.CYAN);
        optionsLabel.setFont(new Font("Ariel", Font.PLAIN, 20));
        add(optionsLabel);

    }
}
