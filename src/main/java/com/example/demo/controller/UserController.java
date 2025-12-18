package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User u = userService.registerUser(user);
        if (u == null) {
            return ResponseEntity.status(400).body(null); // Return bad request if registration fails
        }
        return ResponseEntity.status(201).body(u);
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
