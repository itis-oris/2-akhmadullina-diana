package com.pyatnashki.controller.listener;

import com.pyatnashki.model.User;
import com.pyatnashki.service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.*;


@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        Map<String, User> users = new HashMap<>();
        ArrayList<User> pairs = new ArrayList<>();

        UserService userService = new UserService();

        servletContext.setAttribute("users", users);
        servletContext.setAttribute("pairs", pairs);
        servletContext.setAttribute("userService", userService);
    }
    public void contextDestroyed(ServletContextEvent event) {
        Map userSessions = (Map) event.getServletContext().getAttribute("USER_SESSIONS");
        userSessions.clear();
    }
}
