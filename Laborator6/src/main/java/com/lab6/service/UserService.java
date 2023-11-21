package com.lab6.service;

import static com.lab6.mapper.UserMapper.convertToUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab6.dto.UserDto;
import com.lab6.entity.User;
import com.lab6.mapper.UserMapper;
import com.lab6.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public void addUser(UserDto userDto){
        User user = convertToUser(userDto);
        userRepository.createUser(user);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

}
