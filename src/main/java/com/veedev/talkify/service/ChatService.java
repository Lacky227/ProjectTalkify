package com.veedev.talkify.service;

import com.veedev.talkify.model.Chat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChatService {
    ResponseEntity<String> createChat(String chatName);
    ResponseEntity<List<Chat>> getUserChats(int userId);
}
