package com.example.laborator4.transformer;

import com.example.laborator4.dto.UserDTO;
import com.example.laborator4.dto.UserOrderDTO;
import com.example.laborator4.model.User;

public class UserTransformer {

    public static UserDTO convertUserToUserDto(User user){
        return UserDTO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }

    public static User convertUserDtoToUser(UserDTO userDTO){
        return User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .username(userDTO.getUsername())
                .build();
    }

    public static UserOrderDTO transformUserToUserOrderDto(User user){
        return UserOrderDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .productName(user.getOrder().getProductName())
                .price(user.getOrder().getPrice())
                .quantity(user.getOrder().getQuantity())
                .build();
    }


}
