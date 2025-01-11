package com.veedev.talkify.controller;

import com.veedev.talkify.dto.MessageRequest;
import com.veedev.talkify.dto.SocketMessage;
import com.veedev.talkify.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.client.WebSocketClient;

@Controller
@RequiredArgsConstructor
public class WebSocketController {
    private final MessageService messageService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public SocketMessage sendMessage(SocketMessage webSocketMessage){
        messageService.sendMessage(webSocketMessage);
        return webSocketMessage;
    }
}
