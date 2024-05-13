package com.phonebook;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ErrorDto {
    // Класс для передачи ошибок в контроллере
    // Обязательно использовать оригинальный регистр букв+
    private String error;
    private String path;
    private int status;
    private Object message;
 }
