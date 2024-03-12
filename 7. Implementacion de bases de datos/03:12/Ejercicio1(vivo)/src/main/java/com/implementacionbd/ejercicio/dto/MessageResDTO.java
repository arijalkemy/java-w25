package com.implementacionbd.ejercicio.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageResDTO {
    String message;

    public MessageResDTO(String message) {
        this.message = message;
    }

}
