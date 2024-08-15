package ru.nurullin.jwptoken.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String email;
    private String telNumber;
}
