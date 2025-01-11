package com.veedev.talkify.dto;

import lombok.Data;

@Data
public class SocketMessage {
    private String content;
    private int senderId;
    private Long chatId;
}
