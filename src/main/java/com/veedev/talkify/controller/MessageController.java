package com.veedev.talkify.controller;

import com.veedev.talkify.dto.MessageRequest;
import com.veedev.talkify.model.Message;
import com.veedev.talkify.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request) {
        return messageService.sendMessage(request);
    }

    @GetMapping("/chat/{chatid}")
    public ResponseEntity<List<Message>> getChatMessage(@PathVariable Long chatid) {
        return messageService.getMessages(chatid);
    }
}
