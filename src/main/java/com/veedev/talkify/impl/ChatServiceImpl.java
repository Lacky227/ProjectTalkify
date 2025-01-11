package com.veedev.talkify.impl;

import com.veedev.talkify.model.Chat;
import com.veedev.talkify.model.User;
import com.veedev.talkify.repository.ChatRepository;
import com.veedev.talkify.repository.UserRepository;
import com.veedev.talkify.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> createChat(String chatName) {
        Chat chat = new Chat();
        chat.setName(chatName);
        chatRepository.save(chat);
        return ResponseEntity.status(HttpStatus.CREATED).body("Chat " + chatName + " created");
    }

    @Override
    public ResponseEntity<List<Chat>> getUserChats(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(chatRepository.findAll().stream()
                .filter(chat -> chat.getParticipants().contains(user))
                .toList());
    }
}
