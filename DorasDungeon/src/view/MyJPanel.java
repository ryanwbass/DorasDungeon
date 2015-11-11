/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.OptionsController;
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
            
        public ButtonPanel buttonsPane;
        public MainPanel mainPane;
//        Options optPane;
        public OptionsView optionsView;
        public InstructionsView instructionsView;
        public OptionsModel optionsModel;
        public OptionsController optionsController;
    
	public MyJPanel()
	{
            super();
            setBackground(Color.DARK_GRAY);
            setForeground(Color.CYAN);
            setLayout(new BorderLayout());
            

            mainPane = new MainPanel();
            add(mainPane, BorderLayout.CENTER);
            

            buttonsPane = new ButtonPanel();            
            add(buttonsPane, BorderLayout.SOUTH);
            
            //create instances of other panels, but don't add them yet
            optionsModel = new OptionsModel();
            optionsView = new OptionsView(optionsModel);
            optionsController = new OptionsController(optionsView, optionsModel, this);
            instructionsView = new InstructionsView();
            
                                    
            //add action listeners for buttons to show new panel
            buttonsPane.options.addActionListener(this);
            optionsView.returnButton.addActionListener(this);
            buttonsPane.instructions.addActionListener(this);
            instructionsView.returnButton.addActionListener(this);
                                   
        }
        
        public void clearTopPanel()
        {
//            remove(mainPane);
//            remove(optionsView);
            
            BorderLayout layout = (BorderLayout) this.getLayout();
            this.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            
            revalidate();
            repaint();
        }
        
        public void clearTopPanel(JPanel panel) {
        
            remove(panel);
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
        
        else if (obj == optionsView.returnButton)
        {
            clearTopPanel();
            //How could I modify this to display my options on the optionsLabel located on the mainPane???
            mainPane.optionsLabel.setText(optionsController.getMostRecentOptionChange());
            
            add(mainPane, BorderLayout.CENTER);
        }
        
         else if (obj == instructionsView.returnButton)
        {
            clearTopPanel();
            
            
            add(mainPane, BorderLayout.CENTER);
        }
        
        else if(obj == buttonsPane.instructions){
            
            clearTopPanel();
            System.out.println("test");
            add(instructionsView, BorderLayout.CENTER);
        }
            
   }
    
    

}
