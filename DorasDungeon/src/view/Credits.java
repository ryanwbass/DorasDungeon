/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

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
       add(katie);
       add(ryan);
       add(colin);
       add(dan);
       add(back);
    }
    
    
}
