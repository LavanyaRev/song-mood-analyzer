package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.User;
import com.project.moodanalyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Signup
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Login
    public Optional<User> login(String email, String rawPassword) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()));
    }

    // Find user by email (for signup check)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

