package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Katie on 11/1/2015.
 */
public class OptionButton extends JButton {

    public OptionButton() {

        super();


        setFont(new Font("Ariel", Font.PLAIN, 30));
        setForeground(Color.CYAN);
        setBackground(Color.DARK_GRAY);
        setMargin(new Insets(20, 20, 20, 20));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

}
