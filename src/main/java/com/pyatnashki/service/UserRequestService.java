package com.pyatnashki.service;

import com.pyatnashki.model.User;
import com.pyatnashki.handler.UserRequestHandler;

import java.util.ArrayList;

public class UserRequestService {
    UserRequestHandler requestHandler;

    public UserRequestService() {
        requestHandler = new UserRequestHandler();
    }

    public void onMove(User u){
        requestHandler.onMove(u);
    }

    public int getPairMove(User u) {
        return requestHandler.getPairMove(u);
    }

    public ArrayList<String> getPairOrder(User u) {
        return requestHandler.getPairOrder(u);
    }

    public boolean getPairFlag(User u) {
        return requestHandler.getPairFlag(u);
    }

    public int getCount(User u) {
        return requestHandler.getCount(u);
    }

    public String getPairName(User u) {
        return requestHandler.getPairName(u);
    }
}
