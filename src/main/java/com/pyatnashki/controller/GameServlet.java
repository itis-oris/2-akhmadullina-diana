package com.pyatnashki.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyatnashki.model.User;
import com.pyatnashki.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");

        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String ans = "";

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        String body = getBody(req);

        JsonNode rootNode = mapper.readTree(body);

        JsonNode userNode = rootNode.get("user");
        String userJson = mapper.writeValueAsString(userNode);

        JsonNode typeNode = rootNode.get("type");
        String type = mapper.writeValueAsString(typeNode).replaceAll("\"", "");

        User u = mapper.readValue(userJson, User.class);
        if (type.equals("write")) {
            System.out.println("write request");
            userService.add(u);
        }
        else if (type.equals("getPairCode")) {
//            ans = String.valueOf(userService.getPairKeyCode(u));
//            System.out.println("ans " + ans);
            mapper.writeValue(response.getWriter(), userService.getPairKeyCode(u));
        }
        else if (type.equals("getPairOrder")) {
            mapper.writeValue(response.getWriter(), userService.getPairOrder(u));
        }
        else if (type.equals("getPairFlag")) {
            mapper.writeValue(response.getWriter(), userService.getPairFlag(u));
        }
        else if (type.equals("getCount")) {
            mapper.writeValue(response.getWriter(), userService.getCount(u));
        }
        else if (type.equals("getPairName")) {
            mapper.writeValue(response.getWriter(), userService.getName(u));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    }

    private static String getBody(HttpServletRequest req) {
        StringBuilder postData = new StringBuilder();
        String line;
        try (BufferedReader reader = req.getReader()) {
            while ((line = reader.readLine()) != null) {
                postData.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return postData.toString();
    }
}