package com.phonebook;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ContactDto {
    // Класс для передачи контактов в контроллере
    // Обязательно использовать оригинальный регистр букв
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String description;
}
