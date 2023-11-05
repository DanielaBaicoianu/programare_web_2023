package com.example.laborator3.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.laborator3.model.User;
import com.example.laborator3.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    List<User> usersRepository = new ArrayList<>();

    private Optional<User> findByUsername(String username){

        return usersRepository.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public void addUser(User user) {
        if (!findByUsername(user.getUsername()).isPresent()) {
            user.setJoinDate(LocalDateTime.now());
            usersRepository.add(user);
        } else {
            System.out.println("User is already present");
        }
    }

    @Override
    public void removeUser(String username) {
        Optional<User> foundUser = findByUsername(username);

        User user = foundUser.isPresent() ? foundUser.get() : null;
        if(user != null)
            usersRepository.remove(user);
    }

    @Override
    public List<User> editUserEmail(String username, String email) {
        Optional<User> foundUser = findByUsername(username);
        if(foundUser.isPresent()){
            User user = foundUser.get();
            usersRepository.remove(user);
            user.setEmail(email);
            usersRepository.add(user);
        }
        return usersRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return usersRepository;
    }
}
