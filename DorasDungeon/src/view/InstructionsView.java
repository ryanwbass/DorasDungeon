/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;



/**
 *
 * @author Striped
 */
public class InstructionsView extends JPanel{
    
    public OptionButton returnButton;
    JLabel line1;
    JLabel line2;
    JLabel line3;
    
     
    public InstructionsView() {
        

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.DARK_GRAY);
        
        line1 = new JLabel("Using the arrow keys, guide Dora to the checkered flag space to win the game.");
        line1.setForeground(Color.CYAN);
        
        line2 = new JLabel("But watch out! If you fail to make it to the end before the turn count hits 0, you lose the game.");
        line2.setForeground(Color.CYAN);
        
        line3 = new JLabel("Collect the Yellow Orbs to increase your score as you move through the dungeon.");
        line3.setForeground(Color.CYAN);
        
        returnButton = new OptionButton();
        returnButton.setText("Return to Main Menu");
        
        this.add(line1);
        this.add(Box.createVerticalStrut(20));
        this.add(line2);
        this.add(Box.createVerticalStrut(20));
        this.add(line3);
        this.add(Box.createVerticalStrut(20));
        this.add(returnButton);
        
        
        

    }
}
    


