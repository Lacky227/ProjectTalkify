package com.veedev.talkify.service;

import com.veedev.talkify.dto.MessageRequest;
import com.veedev.talkify.model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    ResponseEntity<String> sendMessage(MessageRequest request);
    ResponseEntity<List<Message>> getMessages(Long chatId);
}
