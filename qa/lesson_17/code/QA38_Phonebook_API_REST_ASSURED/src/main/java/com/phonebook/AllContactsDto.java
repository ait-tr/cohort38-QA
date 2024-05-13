package com.phonebook;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
public class AllContactsDto {
    // Класс для передачи всех контактов в контроллере
    // Список всех контактов из ContactsDto
    private List<ContactDto> contacts;
}
