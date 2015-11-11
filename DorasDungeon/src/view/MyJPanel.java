/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.OptionsModel;

/**
 *
 * @author Katie
 */
public class MyJPanel extends JPanel implements ActionListener {
            
        ButtonPanel buttonsPane;
        MainPanel mainPane;
//        Options optPane;
        OptionsView optionsView;
    
	public MyJPanel()
	{
            super();
            setBackground(Color.gray);		
            setLayout(new BorderLayout());
            

            mainPane = new MainPanel();
            add(mainPane, BorderLayout.CENTER);
            

            buttonsPane = new ButtonPanel();            
            add(buttonsPane, BorderLayout.SOUTH);
            
            //create instances of other panels, but don't add them yet
            OptionsModel optionsModel = new OptionsModel();
            optionsView = new OptionsView(optionsModel);
            
                                    
            //add action listeners for buttons to show new panel
            buttonsPane.options.addActionListener(this);
            
            //add action listener for buttons to return to main panel
//            optPane.retButton.addActionListener(this);
                                   
        }
        
        public void clearTopPanel()
        {
            remove(mainPane);
            remove(optionsView);
            revalidate();
            repaint();
        }
        

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj==buttonsPane.options)
        {            
            clearTopPanel();                        
            add(optionsView, BorderLayout.CENTER);
        
        }
//        else if (obj == optionsView.retButton)
//        {
//            clearTopPanel();
//            //How ould I modify this to display my options on the optionsLabel located on the mainPane???
//            
//            add(mainPane, BorderLayout.CENTER);
//        }
   }

}
