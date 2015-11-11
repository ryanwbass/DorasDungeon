package view;

import model.UserList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/1/2015.
 */
public class CreateNewUserPanel extends JFrame {

    public JButton submit, returnToMainMenu;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public CreateNewUserPanel(UserList model) {

        super();

        JPanel panel = new JPanel();

        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.setMargin(new Insets(10, 10, 10, 10));
        returnToMainMenu.setBackground(Color.DARK_GRAY);
        returnToMainMenu.setForeground(Color.CYAN);
        returnToMainMenu.setFont(new Font("Ariel", Font.PLAIN, 20));
        returnToMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(returnToMainMenu);

        JLabel title = new JLabel("Create a New User");
        title.setFont(new Font("Ariel", Font.PLAIN, 30));
        title.setForeground(Color.CYAN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createVerticalStrut(50));

//        field1 holds the first name label and text field
        JPanel field1 = new JPanel(new FlowLayout());
        field1.setBackground(Color.DARK_GRAY);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
        firstNameLabel.setForeground(Color.CYAN);
        field1.add(firstNameLabel);

        firstNameField = new JTextField(20);
        firstNameField.setFont(new Font("Ariel", Font.PLAIN, 25));
        field1.add(firstNameField);

        panel.add(field1);

//          field2 holds the last name label and text field
        JPanel field2 = new JPanel(new FlowLayout());
        field2.setBackground(Color.DARK_GRAY);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
        lastNameLabel.setForeground(Color.CYAN);
        field2.add(lastNameLabel);

        lastNameField = new JTextField(20);
        lastNameField.setFont(new Font("Ariel", Font.PLAIN, 25));
        field2.add(lastNameField);

        panel.add(field2);

        submit = new JButton("Submit");
        submit.setMargin(new Insets(10, 10, 10, 10));
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.CYAN);
        submit.setFont(new Font("Ariel", Font.PLAIN, 20));
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(submit);

        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
//        this.setSize(400, 100);
        this.pack();
        this.setTitle("Add User Option");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void addSubmitBtnListener(ActionListener action) {
        submit.addActionListener(action);
    }

    public String getFirstNameField() {
        return firstNameField.getText();
    }

    public String getLastNameField() {
        return lastNameField.getText();
    }

    public void clearNameFields() {
        firstNameField.setText("");
        lastNameField.setText("");
    }

    public void addReturnToMainMenuListener(ActionListener action) {
        returnToMainMenu.addActionListener(action);
    }
}
