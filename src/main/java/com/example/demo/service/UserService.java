package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService{
    public User registerUser(User user);
    public User getUser(long id);
    public List<User> getAllUsers();
    public User getByEmail(String email);
}