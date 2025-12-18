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
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ValidationException("Email already in use");
        }

        if (user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("User not found with ID " + id));
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
