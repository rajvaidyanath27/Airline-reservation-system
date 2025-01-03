package com.airline.service;

import com.airline.dao.UserDao;
import com.airline.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    // Method to register a user
    public boolean registerUser(User user) {
        // Validate user details (if necessary)
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return false;
        }
        return userDao.registerUser(user); // Delegate to DAO for database insertion
    }

    // Method to login a user
    public User loginUser(String email, String password) {
        // Validate credentials
        if (email == null || password == null) {
            return null;
        }
        return userDao.loginUser(email, password); // Delegate to DAO for authentication
    }
}
