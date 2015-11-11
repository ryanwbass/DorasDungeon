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
    
     
    public InstructionsView() {
        

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.DARK_GRAY);

        // set up Btns on View
        returnButton = new OptionButton();
        returnButton.setText("Return to Main Menu");
        this.add(returnButton);
        this.add(Box.createVerticalStrut(20));
        
        
        

    }
}
    


