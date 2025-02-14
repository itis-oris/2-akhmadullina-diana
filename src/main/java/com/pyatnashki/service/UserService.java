package com.pyatnashki.service;

import com.pyatnashki.model.User;
import com.pyatnashki.repository.UserRepository;

import java.util.ArrayList;
import java.util.Map;

public class UserService {
    UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public void add(User user) {
        repository.add(user);
    }

    public Map<String, User> getUsers() {
        return repository.getUsers();
    }

    public int getPairKeyCode(User user) {
        return repository.getPairKeyCode(user);
    }

    public ArrayList<String> getPairOrder(User user) {
        return repository.getPairOrder(user);
    }

    public boolean getPairFlag(User user) {
        return repository.getPairFlag(user);
    }

    public int getCount(User user) {
        return repository.getCount(user);
    }

    public String getName(User user) {
        return repository.getName(user);
    }

}
