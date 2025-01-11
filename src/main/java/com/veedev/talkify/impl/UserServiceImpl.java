package com.veedev.talkify.impl;

import com.veedev.talkify.dto.LoginRequest;
import com.veedev.talkify.dto.RegisterRequest;
import com.veedev.talkify.model.User;
import com.veedev.talkify.repository.UserRepository;
import com.veedev.talkify.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> registerUser(RegisterRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        if(userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        if(userRepository.existsByNumberPhone(request.getNumberPhone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone number already exists");
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setNumberPhone(request.getNumberPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @Override
    public ResponseEntity<String> loginUser(LoginRequest request) {
        User user = userRepository.findByNumberPhone(request.getPhoneNumber());
        if(user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid phone number");
        }
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }
        return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully");
    }
}
