package com.example.laborator3.service;

import java.util.List;

import com.example.laborator3.model.User;

public interface UserService {

    void addUser(User user);

    void removeUser(String username);

    List<User> editUserEmail(String username, String email);

    List<User> getAllUsers();
}
