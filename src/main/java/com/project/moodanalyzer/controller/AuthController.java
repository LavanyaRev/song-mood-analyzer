package com.project.moodanalyzer.controller;
//AuthController.java
import com.project.moodanalyzer.entity.User;
import com.project.moodanalyzer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ---------------- Signup ----------------
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        // Check if email already exists
        Optional<User> existing = authService.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("Email already registered");
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = authService.registerUser(user);

        return ResponseEntity.ok(savedUser);
    }


    // ---------------- Login ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> existing = authService.login(user.getEmail(), user.getPassword());

        if (existing.isEmpty()) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        // Login successful
        User loggedInUser = existing.get();
        return ResponseEntity.ok(loggedInUser);
    }
}
