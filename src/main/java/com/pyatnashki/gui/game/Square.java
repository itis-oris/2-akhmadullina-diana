package com.pyatnashki.gui.game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Square extends JButton {
    private StretchIcon icon;
    private String value;

    public Square(String image, String value) {
        super();
        try {
            if (image != null) {
                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                InputStream is = classloader.getResourceAsStream(image);
                this.icon = new StretchIcon(is.readAllBytes());
                this.setIcon(icon);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.value = value;
        removeActionListener(this.actionListener);
        Arrays.stream(this.getMouseListeners()).forEach(this::removeMouseListener);
        this.setBackground(new Color(255, 255, 255));
        this.setBorderPainted(true);
        this.setName(value);
    }


}
