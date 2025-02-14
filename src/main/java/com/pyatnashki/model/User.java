package com.pyatnashki.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    String secretKey;
    ArrayList<String> order;
    String pairSecretKey;
    int keycode;
    boolean flag;
    int count;

    public User(String name) {
        this.name = name;
        secretKey = String.valueOf(UUID.randomUUID());
        order = new ArrayList<>();
        pairSecretKey = "";
        flag = false;
    }

    public User(String secretKey, String name) {
        this.secretKey = secretKey;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name = " + name + ", keycode = " + keycode + " pair " + pairSecretKey + "\norder = " + order;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}