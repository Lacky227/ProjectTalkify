package com.veedev.talkify.impl;

import com.veedev.talkify.dto.MessageRequest;
import com.veedev.talkify.dto.SocketMessage;
import com.veedev.talkify.model.Chat;
import com.veedev.talkify.model.Message;
import com.veedev.talkify.model.User;
import com.veedev.talkify.repository.ChatRepository;
import com.veedev.talkify.repository.MessageRepository;
import com.veedev.talkify.repository.UserRepository;
import com.veedev.talkify.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;


    @Override
    public ResponseEntity<String> sendMessage(SocketMessage socketMessage) {
        Chat chat = chatRepository.findById(socketMessage.getChatId()).orElse(null);
        User user = userRepository.findById(socketMessage.getSenderId()).orElse(null);

        if (chat == null || user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chat or User not found");
        }
        Message message = new Message();
        message.setChat(chat);
        message.setSender(user);
        message.setContent(socketMessage.getContent());
        messageRepository.save(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message sent");
    }

    @Override
    public ResponseEntity<List<Message>> getMessages(Long chatId) {
        Chat chat = chatRepository.findById(chatId).orElse(null);
        if (chat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.findAll().stream()
                .filter(message -> message.getChat().equals(chat))
                .toList());
    }
}
