/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Katie
 */
public class ButtonPanel extends JPanel{
    JButton options;
    JButton instructions;
    JButton credits;  
    
    ButtonPanel()
          
    {
        super();       
        options = new JButton("Options");
        instructions = new JButton("Instructions");
        credits = new JButton("Credits");

        add(options, BorderLayout.SOUTH);
        add(instructions, BorderLayout.SOUTH);
        add(credits, BorderLayout.SOUTH);        
                
    }
}
