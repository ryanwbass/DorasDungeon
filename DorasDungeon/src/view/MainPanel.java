/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
            splashButton = new JButton(new ImageIcon("src/images/codeattacks.png"));            
            add(splashButton);
            
            optionsLabel = new JLabel("No options selected yet.");
            add(optionsLabel);
            
    }
}
