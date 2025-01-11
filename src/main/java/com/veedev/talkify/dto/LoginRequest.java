package com.veedev.talkify.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String password;
}
