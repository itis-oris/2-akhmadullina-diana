package com.pyatnashki;

import com.pyatnashki.handler.UserRequestHandler;
import com.pyatnashki.model.User;
import com.pyatnashki.service.UserRequestService;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        UserRequestService requestService = new UserRequestService();
        User user1 = new User("1", "s3", new ArrayList<>(asList("6", "7", "8", "0", "1", "2", "3", "4", "5")), "s4", 0, false, 1);
        User user2 = new User("2", "s4", new ArrayList<>(asList("0", "1", "2", "3", "4", "5", "6", "7", "8")), "s3", 0, false, 2);

        user1.setCount(3);
        requestService.onMove(user1);
        requestService.onMove(user2);

        System.out.println("yey " + requestService.getCount(user2));
    }
}
