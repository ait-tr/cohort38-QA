package com.phonebook;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class AuthResponseDto {
    // Класс для передачи токена в контроллере
    private String token;
}
