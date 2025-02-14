package com.pyatnashki.gui.start;

import com.pyatnashki.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class AddFrame extends JFrame {
    private final JButton btnAdd;
    private LinkedList<User> users;

    public AddFrame() {
        super("Start");

        users = new LinkedList<>();

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        btnAdd = new JButton("Add player");
        btnAdd.addActionListener(e -> addPlayer());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addPlayer() {
        WelcomeFrame welcomeFrame = new WelcomeFrame(users);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddFrame::new);
    }
}
