package com.veedev.talkify.controller;

import com.veedev.talkify.model.Chat;
import com.veedev.talkify.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chat")
@AllArgsConstructor
public class ChatController {
    private ChatService chatService;

    @PostMapping("/create")
    public ResponseEntity<String> createChat(@RequestBody String chatName) {
        return chatService.createChat(chatName);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Chat>> getChat(@PathVariable int userId) {
        return chatService.getUserChats(userId);
    }
}
