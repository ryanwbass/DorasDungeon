/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author dil5315
 */
public class Credits extends JPanel
{
    JLabel label; 
    JLabel katie; 
    JLabel ryan; 
    JLabel colin; 
    JLabel dan; 
    JButton back; 
    
    Credits()
    {
       label = new JLabel("TEAM 2");
       katie = new JLabel("Katie Dodds: Options Menu");
       ryan = new JLabel("Ryan Bass: Splash Artist, Instructions Panel");
       colin = new JLabel("Colin Burns: ");
       dan = new JLabel("Daniel Lavanier: Credits Panel");
       back = new JButton("Return");
       
       add(label);
       add(Box.createVerticalStrut(20));
       add(katie);
       add(Box.createVerticalStrut(20));
       add(ryan);
       add(Box.createVerticalStrut(20));
       add(colin);
       add(Box.createVerticalStrut(20));
       add(dan);
       add(Box.createVerticalStrut(20));
       add(back);
    }
    
    public void addReturnButtonListener(ActionListener al)
    {
        back.addActionListener(al);
    }
    
    
}
