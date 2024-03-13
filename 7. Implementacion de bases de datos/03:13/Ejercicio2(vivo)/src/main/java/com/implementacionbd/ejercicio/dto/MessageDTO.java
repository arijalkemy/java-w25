package com.implementacionbd.ejercicio.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {
    String message;

    public MessageDTO(String message) {
        this.message = message;
    }

}
