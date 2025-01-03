package com.airline.controller;

import com.airline.model.User;
import com.airline.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // Retrieve form data
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // Authenticate user
            User user = userService.loginUser(email, password);
            if (user != null) {
                // Start session and redirect to home page
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("home.jsp");
            } else {
                resp.getWriter().println("Error: Invalid email or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: Unable to process your request.");
        }
    }
}
