package com.pyatnashki.gui;

import com.pyatnashki.model.User;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
public class FinalFrame extends JFrame {
    JButton btn;

    public FinalFrame(String name) {
        super("Results");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Winner is " + name, JLabel.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        add(lblTitle, BorderLayout.CENTER);

        setVisible(true);
    }
}
