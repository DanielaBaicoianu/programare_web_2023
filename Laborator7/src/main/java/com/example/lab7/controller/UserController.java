package com.example.lab7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab7.dto.UserDto;

import com.example.lab7.controller.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<List<UserDto>> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUsersByUsername(username));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @GetMapping("/getByType")
    public ResponseEntity<List<UserDto>> getByType(@RequestParam("username") String username, @RequestParam("type") String type){
        return ResponseEntity.ok(userService.getUserByUsernameAndType(username, type));
    }
}
