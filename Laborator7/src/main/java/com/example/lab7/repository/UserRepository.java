package com.example.lab7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.lab7.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByUsername(String username);

    @Query("SELECT u from User u where u.username = :username AND u.userType = :userType")
    List<User> findUserByCustomQuery(String username, String userType);
}
