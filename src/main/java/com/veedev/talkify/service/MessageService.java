package com.veedev.talkify.service;

import com.veedev.talkify.dto.MessageRequest;
import com.veedev.talkify.dto.SocketMessage;
import com.veedev.talkify.model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    ResponseEntity<String> sendMessage(SocketMessage message);
    ResponseEntity<List<Message>> getMessages(Long chatId);
}
