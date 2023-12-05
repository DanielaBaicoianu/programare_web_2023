package com.example.lab7.mapper;

import com.example.lab7.dto.UserDto;

import com.example.lab7.entity.User;

public class UserMapper {

    public static UserDto convertToDto(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .fullName(user.getFullName())
                .userType(user.getUserType())
                .build();
    }

    public static User convertToUser(UserDto userDto){
        return User.builder()
                .fullName(userDto.getFullName())
                .username(userDto.getUsername())
                .userType(userDto.getUserType())
                .build();
    }

}
