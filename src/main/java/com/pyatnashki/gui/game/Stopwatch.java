package com.pyatnashki.gui.game;

import javax.swing.*;
import java.awt.*;


public class Stopwatch extends JLabel {
    private final Timer timer;
    private int elapsedTime;

    public Stopwatch() {
        super("time: 00:00:00");
        setFont(new Font("Courier New", Font.PLAIN, 20));
        timer = new Timer(1000, e -> {
            elapsedTime += 1000;
            updateTimeLabel();
        });
        timer.start();
    }

    private void updateTimeLabel() {
        int hours = elapsedTime / 3600000;
        int minutes = (elapsedTime % 3600000) / 60000;
        int seconds = (elapsedTime % 60000) / 1000;
        String time = String.format("time: %02d:%02d:%02d", hours, minutes, seconds);
        this.setText(time);
    }

}