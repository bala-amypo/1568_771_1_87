package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.status(201).body(savedUser);
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            User user = userService.getUser(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID " + id));
            return ResponseEntity.ok(user);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        Optional<User> user = userService.getByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }
}
