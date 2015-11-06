/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Katie
 */
public class Options extends JPanel{
        JButton retButton;
        JTextField playerName;
        JLabel EnterDiff;
        JSlider difficulty;
        
    Options(){
        
        // You should select different options based on your applications, and
        // and use a layout manager to make the screen look nice!
        
        playerName = new JTextField("--Enter Player Name--");
        difficulty = new JSlider(JSlider.HORIZONTAL, 1,10,5);
        difficulty.setMajorTickSpacing(1);
        difficulty.setPaintLabels(true);
        difficulty.setPaintTicks(true);
        
        EnterDiff = new JLabel("Enter Difficulty");
        
        retButton = new JButton("Save and Return");

        add(playerName);
        add(EnterDiff);
        add(difficulty);
        
        
        
        add(retButton);
        

        
        
    }
}