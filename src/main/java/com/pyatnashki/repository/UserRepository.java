package com.pyatnashki.repository;

import com.pyatnashki.model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Getter
public class UserRepository {
    Map<String, User> users;
    public UserRepository() {
         users = new HashMap<>();
    }

    public void add(User user) {
        if (!users.containsKey(user.getSecretKey())) {
            System.out.println("ADDDDDD");
            if (!users.isEmpty()) {
                System.out.println("find pair");
                findFree(user);
            }
            users.put(user.getSecretKey(), user);
        }
        else {
            users.get(user.getSecretKey()).setKeycode(user.getKeycode());
            users.get(user.getSecretKey()).setOrder(user.getOrder());
            users.get(user.getSecretKey()).setFlag(user.getFlag());
        }
    }

    public int getPairKeyCode(User user) {
        String pairSecretKey = getPairSecretKey(user);
        if (!pairSecretKey.isEmpty()) {
            System.out.println("got pair");
            return users.get(pairSecretKey).getKeycode();
        }
        System.out.println("no pair");
        return 0;
    }

    public ArrayList<String> getPairOrder(User user) {
        String pairSecretKey = getPairSecretKey(user);
        if (!pairSecretKey.isEmpty()) {
            System.out.println("got pair");
            return users.get(pairSecretKey).getOrder();
        }
        System.out.println("no pair");
        return new ArrayList<>();
    }

    public boolean getPairFlag(User user) {
        String pairSecretKey = getPairSecretKey(user);
        if (!pairSecretKey.isEmpty()) {
            System.out.println("got pair");
            return users.get(pairSecretKey).getFlag();
        }
        return false;
    }

    public int getCount(User user) {
        String pairSecretKey = getPairSecretKey(user);
        if (!pairSecretKey.isEmpty()) {
            return users.get(pairSecretKey).getCount();
        }
        return 0;
    }

    public String getName(User user) {
        String pairSecretKey = getPairSecretKey(user);
        if (!pairSecretKey.isEmpty()) {
            return users.get(pairSecretKey).getName();
        }
        return "";
    }

    private void findFree(User young) {
        users.forEach( (secretKey,u) -> {
                    if (u.getPairSecretKey().isEmpty()) {
                        System.out.println("empty");
                        makePair(u, young);
                    }
                }
        );
    }

    private void makePair(User young, User old) {
        System.out.println("set new pair key " + young + " " + old);
        young.setPairSecretKey(old.getSecretKey());
        old.setPairSecretKey(young.getSecretKey());
    }

    private String getPairSecretKey(User user) {
        return users.get(user.getSecretKey()).getPairSecretKey();
    }
}
