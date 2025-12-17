package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService{
    public User registerUser(User user);
    public Optional<User> getUser(long id);
    public List<User> getAllUsers();
    public Optional<User> getByEmail(String email);
}