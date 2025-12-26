package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.*;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
    }

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail()))
            throw new ValidationException("Email already in use");

        if (user.getPassword().length() < 8)
            throw new ValidationException("Password must be at least 8 characters");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) user.setRole("USER");
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
