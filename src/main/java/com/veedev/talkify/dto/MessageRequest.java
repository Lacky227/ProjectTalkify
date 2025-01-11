package com.veedev.talkify.dto;

import lombok.Data;

@Data
public class MessageRequest {
    private Long chatId;
    private int senderId;
    private String content;
}
