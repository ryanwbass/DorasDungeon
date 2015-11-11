/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Katie
 */
public class ButtonPanel extends JPanel{
    OptionButton options;
    OptionButton instructions;
    OptionButton credits;  
    
    ButtonPanel()
          
    {
        super();       
        options = new OptionButton();
        options.setText("Options");
        instructions = new OptionButton();
        instructions.setText("Instructions");
        credits = new OptionButton();
        credits.setText("Credits");

        add(options, BorderLayout.SOUTH);
        add(instructions, BorderLayout.SOUTH);
        add(credits, BorderLayout.SOUTH);       
        
        setBackground(Color.DARK_GRAY);
        setForeground(Color.CYAN);
            
    }
}
