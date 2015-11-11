package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Katie on 11/2/2015.
 */
public class StartGameFrame extends JFrame {

    private JPanel panel;

    public StartGameFrame() {

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("Game Should Start Now");
        label.setFont(new Font("Ariel", Font.PLAIN, 20));
        label.setForeground(Color.CYAN);
        panel.add(label);

        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setSize(400, 100);
        this.setTitle("Start Game Option");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
