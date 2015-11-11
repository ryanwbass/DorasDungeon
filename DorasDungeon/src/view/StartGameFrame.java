package view;

import controller.OptionsController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.OptionsModel;

/**
 * Created by Katie on 11/2/2015.
 */
public class StartGameFrame extends JPanel implements ActionListener {

    private JPanel panel;
    private OptionButton returnButton;

    private MyJPanel parentPanel;
    
    public StartGameFrame(MyJPanel parentPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.DARK_GRAY);
        
        this.parentPanel = parentPanel;
        
        returnButton = new OptionButton();
        returnButton.setText("Options Menu");
        returnButton.addActionListener(this);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(returnButton);
        this.add(Box.createVerticalStrut(20));

        JLabel label = new JLabel("Game Should Start Now");
        label.setFont(new Font("Ariel", Font.PLAIN, 20));
        label.setForeground(Color.CYAN);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        parentPanel.clearTopPanel(this);
                    
        parentPanel.add(parentPanel.optionsView, BorderLayout.CENTER);
        
    }
    
    

}
