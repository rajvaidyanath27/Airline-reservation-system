package com.airline.controller;

import com.airline.model.User;
import com.airline.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // Retrieve form data
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int age = Integer.parseInt(req.getParameter("age"));

            // Create User object
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setAge(age);

            // Register user
            boolean success = userService.registerUser(user);
            if (success) {
                resp.sendRedirect("login.jsp?message=Registration Successful");
            } else {
                resp.getWriter().println("Error: Registration failed. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: Unable to process your request.");
        }
    }
}
