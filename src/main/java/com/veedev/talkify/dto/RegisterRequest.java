package com.veedev.talkify.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String username;
    @Email
    private String email;
    @NotEmpty
    private String numberPhone;
    @NotEmpty
    private String password;
    @NotEmpty
    private String role;
}
