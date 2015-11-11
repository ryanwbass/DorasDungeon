/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Katie
 */
public class MyJFrame extends JFrame {
    public MyJFrame(){
        super ("IST Java Final Project");
        MyJPanel mjp = new MyJPanel();
        getContentPane().add(mjp,"Center");        
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (700, 600);
        setVisible(true);         
    }
   
}
