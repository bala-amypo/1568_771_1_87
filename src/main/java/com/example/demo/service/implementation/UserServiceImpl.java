package com.example.demo.service.implementation;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Check if email is already in use
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ValidationException("Email already in use");
        }

        // Check if password meets minimum length
        if (user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        // If role is not set, set default value
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        // Set createdAt date
        user.setCreatedAt(LocalDateTime.now());

        // Save the user to the repository
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        // Return the user wrapped in Optional or throw ResourceNotFoundException
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        // Return all users
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        // Return Optional<User> based on email
        return userRepository.findByEmail(email);
    }
}
