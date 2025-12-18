package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUser(long id);
    List<User> getAllUsers();
    Optional<User> getByEmail(String email);
}
