package com.example.lab7.controller.service;

import static com.example.lab7.mapper.UserMapper.convertToDto;
import static com.example.lab7.mapper.UserMapper.convertToUser;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab7.dto.UserDto;
import com.example.lab7.mapper.UserMapper;
import com.example.lab7.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsersByUsername(String username) {
        return userRepository.findUserByUsername(username).stream()
                .map(u -> UserMapper.convertToDto(u))
                .collect(Collectors.toList());
    }

    public UserDto addUser(UserDto userDto){
        return convertToDto(userRepository.save(convertToUser(userDto)));
    }

    public List<UserDto> getUserByUsernameAndType(String username, String type){
        return userRepository.findUserByCustomQuery(username, type)
                .stream()
                .map(u -> convertToDto(u))
                .collect(Collectors.toList());
    }
}
