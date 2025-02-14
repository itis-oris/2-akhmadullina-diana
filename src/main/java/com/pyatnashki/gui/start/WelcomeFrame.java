//package com.pyatnashki.gui;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class WelcomeFrame extends JFrame {
//    private final JTextField tfUserName;
//    private final JTextArea taWelcome;
//
//    public WelcomeFrame() {
//        super("Add users");
//
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setSize(1000, 1000);
//
//        //setLayout(new GridLayout());
//
//        tfUserName = new JTextField(25);
//        taWelcome = new JTextArea("Enter your name:");
//
//        JPanel panel = new JPanel();
//        panel.add(tfUserName, BorderLayout.CENTER);
//        panel.add(taWelcome, BorderLayout.CENTER);
//        panel.setVisible(true);
//
//        add(panel, BorderLayout.CENTER);
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        WelcomeFrame welcomeFrame = new WelcomeFrame();
//    }
//}
package com.pyatnashki.gui.start;

import com.pyatnashki.model.User;
import com.pyatnashki.gui.game.Board;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class WelcomeFrame extends JFrame {
    private final JTextField tfUserName;
    private final JButton btnSubmit;
    LinkedList<User> users;

    public WelcomeFrame(LinkedList<User> users) {
        super("Welcome!");
        this.users = users;
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome!", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel lblName = new JLabel("Enter your name:");

        tfUserName = new JTextField(20);
        panel.add(lblName);
        panel.add(tfUserName);

        add(panel, BorderLayout.CENTER);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> showWelcomeMessage());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSubmit);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

        //
        Arrays.stream(panel.getComponents()).forEach(
                a -> System.out.println(a.getName())
        );

    }

    private void showWelcomeMessage() {
        String userName = tfUserName.getText();
        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            // sth.setName(userName)
            // send username to server
            setVisible(false);
            //System.out.println(userName);
            users.add(new User(userName));

            if (users.size() % 2 == 0) {
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        Board board1 = new Board(users.get(0));
                        board1.resetGameBoardTwo();
                        board1.setBounds(10,100,650, 600);
                    }
                });
                Thread t2 = new Thread(new Runnable() {
                    public void run() {
                        Board board2 = new Board(users.get(1));
                        board2.resetGameBoardTwo();
                        board2.setBounds(700,100,650, 600);
                    }
                });
                t1.start();
                t2.start();
            }
        }
    }
}