package com.example.demo.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Check if email is already in use
        if (userRepository.existsByEmail(user.getEmail())) {
            return null; // Email already in use
        }

        // Validate password length
        if (user.getPassword().length() < 8) {
            return null; // Password length too short
        }

        // Manually encode the password (this is a simplified example, replace with a secure method in production)
        user.setPassword("ENCODED_" + user.getPassword()); // Simple password encoding for illustration

        // Set default role to "USER" if not provided
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        // Set current timestamp if not provided
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
