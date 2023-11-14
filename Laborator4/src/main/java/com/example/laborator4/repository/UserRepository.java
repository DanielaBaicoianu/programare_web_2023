package com.example.laborator4.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.laborator4.model.Order;
import com.example.laborator4.model.User;

@Component
public class UserRepository {

    public List<User> usersRepository = new ArrayList<>();

    public Optional<User> findByUsername(String username) {

        return usersRepository.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public void addUser(User user) {
        if (!findByUsername(user.getUsername()).isPresent()) {
            user.setJoinDate(LocalDateTime.now());
            usersRepository.add(user);
        } else {
            System.out.println("User is already present");
        }
    }

    public void removeUser(String username) {
        Optional<User> foundUser = findByUsername(username);

        User user = foundUser.isPresent() ? foundUser.get() : null;
        if (user != null) {
            usersRepository.remove(user);
        }
    }

    public List<User> editUserEmail(String username, String email) {
        Optional<User> foundUser = findByUsername(username);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            usersRepository.remove(user);
            user.setEmail(email);
            usersRepository.add(user);
        }
        return usersRepository;
    }

    public List<User> getAllUsers() {
        return usersRepository;
    }

    public User getOrderByUsername(String username) {
        return findByUsername(username).get();
    }

    public void addUserWithOrder() {
        usersRepository.add(User.builder()
                .password("pass")
                .username("user1")
                .email("email")
                .order(Order.builder()
                        .price(1.6F)
                        .productName("laptop")
                        .quantity(1)
                        .build())
                .build());
    }


}
