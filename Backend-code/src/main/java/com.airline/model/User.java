package com.airline.service;

import com.airline.dao.UserDao;
import com.airline.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    // Method to register a user
    public boolean registerUser(User user) {
        return userDao.registerUser(user);
    }

    // Method to login a user
    public User loginUser(String email, String password) {
        return userDao.loginUser(email, password);
    }
}
