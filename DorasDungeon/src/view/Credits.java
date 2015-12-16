/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
    public JButton back; 
    
    Credits()
    {
       this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
       this.setBackground(Color.DARK_GRAY);
       
       label = new JLabel("TEAM 2");
       label.setForeground(Color.CYAN);
       
       katie = new JLabel("Katie Dodds");
       katie.setForeground(Color.CYAN);
       
       ryan = new JLabel("Ryan Bass");
       ryan.setForeground(Color.CYAN);
       
       colin = new JLabel("Colin Burns");
       colin.setForeground(Color.CYAN);
       
       dan = new JLabel("Daniel Lavanier");
       dan.setForeground(Color.CYAN);
       
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
