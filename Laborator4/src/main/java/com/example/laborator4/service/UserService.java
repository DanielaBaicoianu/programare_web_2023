package com.example.laborator4.service;

import java.util.List;

import com.example.laborator4.dto.UserDTO;
import com.example.laborator4.dto.UserOrderDTO;
import com.example.laborator4.model.User;

public interface UserService {

    void addUser(UserDTO user);

    void removeUser(String username);

    List<User> editUserEmail(String username, String email);

    List<User> getAllUsers();

    UserOrderDTO getOrderByUsername(String username);
}
