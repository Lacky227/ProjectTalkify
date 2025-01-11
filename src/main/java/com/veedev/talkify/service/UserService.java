package com.veedev.talkify.service;

import com.veedev.talkify.dto.LoginRequest;
import com.veedev.talkify.dto.RegisterRequest;
import com.veedev.talkify.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> registerUser(RegisterRequest request);
    ResponseEntity<String> loginUser(LoginRequest request);
}
