package com.pyatnashki.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyatnashki.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class UserRequestHandler {
    HttpClient client;
    HttpRequest request;

    public UserRequestHandler() {
        System.out.println("new client");
        client = HttpClient.newHttpClient();
    }

    public void onMove(User u){
        sendUser(u, "write");
        //System.out.println("Body: " + response.body());
    }

    public ArrayList<String> getPairOrder(User u) {
        HttpResponse response = sendUser(u, "getPairOrder");
        String strResp = (String) response.body();
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<String> order = mapper.readValue(strResp,new TypeReference<ArrayList<String>>(){});
            System.out.println(order);
            return order;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPairMove(User u) {
        HttpResponse response = sendUser(u, "getPairCode");
        String strResp = (String) response.body();

//        if (strResp.length() == 2) {
//            System.out.println("respB is empty");
//            return 0;
//        }
//        strResp = strResp.replaceAll("\"", "");
//        return Integer.parseInt(strResp);

        ObjectMapper mapper = new ObjectMapper();
        try {
            int order = mapper.readValue(strResp, Integer.class);
            System.out.println(order);
            return order;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public int getCount(User u) {
        HttpResponse response = sendUser(u, "getCount");
        String strResp = (String) response.body();
        ObjectMapper mapper = new ObjectMapper();
        try {
            int count = mapper.readValue(strResp, Integer.class);
            return count;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getPairFlag(User u) {
        HttpResponse response = sendUser(u, "getPairFlag");
        String strResp = (String) response.body();
        ObjectMapper mapper = new ObjectMapper();
        try {
            boolean order = mapper.readValue(strResp, Boolean.class);
            System.out.println(order);
            return order;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPairName(User u) {
        HttpResponse response = sendUser(u, "getPairName");
        String strResp = (String) response.body();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String name = mapper.readValue(strResp, String.class);
            return name;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpRequest.BodyPublisher ofForm(User user, String type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return HttpRequest.BodyPublishers.ofString(formBody(mapper.writeValueAsString(user), type));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpResponse sendUser(User u, String type) {
        request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create("http://localhost:8081/pyatnashki/game"))
                .POST(ofForm(u, type))
                .build();

        System.out.println("Req " + u);

        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    private static String formBody(String body, String type) {
        return "{\"user\":" + body + ",\"type\":\"" + type + "\"}";
    }
}
