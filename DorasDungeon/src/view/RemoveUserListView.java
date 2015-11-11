package view;

import model.UserList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Katie on 11/2/2015.
 */
public class RemoveUserListView extends JPanel {

    private UserList model;
    private JButton returnToMainMenu, deleteUser;
    private JList list;

    public RemoveUserListView(UserList model) {

        this.model = model;

        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        returnToMainMenu = new JButton("Options Menu");
        returnToMainMenu.setMargin(new Insets(10, 10, 10, 10));
        returnToMainMenu.setBackground(Color.DARK_GRAY);
        returnToMainMenu.setForeground(Color.CYAN);
        returnToMainMenu.setFont(new Font("Ariel", Font.PLAIN, 20));
        returnToMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(returnToMainMenu);

        list = new JList(model.getUsers());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(200, 300));

        this.add(listScroller);

        deleteUser = new JButton("Delete User");
        deleteUser.setMargin(new Insets(10, 10, 10, 10));
        deleteUser.setBackground(Color.DARK_GRAY);
        deleteUser.setForeground(Color.CYAN);
        deleteUser.setFont(new Font("Ariel", Font.PLAIN, 20));
        deleteUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(deleteUser);
    }

    public void AddReturnToMainMenuListener(ActionListener action) {
        returnToMainMenu.addActionListener(action);
    }

    public void AddDeleteUserListener(ActionListener action) {
        deleteUser.addActionListener(action);
    }

    public JList getUserJList() {
        return list;
    }
}
