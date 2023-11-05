package com.example.laborator3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.laborator3.model.User;
import com.example.laborator3.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{username}")
    public void deleteUserByUsername(@PathVariable String username){
        userService.removeUser(username);
    }

    @PutMapping("/editUser/{username}")
    public List<User> editUserEmail(@RequestParam("email") String emailParam, @PathVariable String username){
        return userService.editUserEmail(username, emailParam);
    }
}
