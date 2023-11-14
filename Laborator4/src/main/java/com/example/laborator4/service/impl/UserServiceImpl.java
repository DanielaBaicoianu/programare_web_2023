package com.example.laborator4.service.impl;

import static com.example.laborator4.transformer.UserTransformer.convertUserDtoToUser;
import static com.example.laborator4.transformer.UserTransformer.transformUserToUserOrderDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laborator4.dto.UserDTO;
import com.example.laborator4.dto.UserOrderDTO;
import com.example.laborator4.model.User;
import com.example.laborator4.repository.UserRepository;
import com.example.laborator4.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public void addUser(UserDTO userDTO) {
        User user = convertUserDtoToUser(userDTO);
        usersRepository.addUser(user);
    }

    @Override
    public void removeUser(String username) {
        usersRepository.removeUser(username);
    }

    @Override
    public List<User> editUserEmail(String username, String email) {
        return usersRepository.editUserEmail(username, email);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    @Override
    public UserOrderDTO getOrderByUsername(String username) {
        usersRepository.addUserWithOrder();
        return transformUserToUserOrderDto(usersRepository.getOrderByUsername(username));
    }
}
