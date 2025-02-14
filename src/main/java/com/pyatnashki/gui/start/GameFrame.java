package com.pyatnashki.gui.start;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    public GameFrame() {
        super("Let's play");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        setLayout(new GridLayout());

        // add game boards
        panel1 = null;
        panel2 = null;

        add(panel1, panel2);

        setVisible(true);
    }
}
