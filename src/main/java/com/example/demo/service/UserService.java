package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
    Optional<User> getByEmail(String email);
}
