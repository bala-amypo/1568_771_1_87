package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User u = userService.registerUser(user);
            return ResponseEntity.status(201).body(u);
        } catch (ValidationException e) {
            return ResponseEntity.status(400).body(null);  // You could return a specific error response here
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable long id) {
        Optional<User> u = userService.getUser(id);
        return ResponseEntity.status(200).body(u);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/email")
    public ResponseEntity<Optional<User>> getByEmail(@RequestParam String email) {
        Optional<User> u = userService.getByEmail(email);
        return ResponseEntity.status(200).body(u);
    }
}
