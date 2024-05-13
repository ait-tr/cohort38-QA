package com.phonebook;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class AuthRequestDto {
    // Класс для передачи данных авторизации в контроллере
    private String username;
    private String password;
}
