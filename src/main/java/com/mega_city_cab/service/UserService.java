package com.mega_city_cab.service;

import com.mega_city_cab.dao.UserDAO;
import com.mega_city_cab.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) { // Remove hashing for testing
            return user;
        }
        return null;
    }

    public boolean signUp(User user) {
        
        return userDAO.addUser(user);
    }

    
    
}