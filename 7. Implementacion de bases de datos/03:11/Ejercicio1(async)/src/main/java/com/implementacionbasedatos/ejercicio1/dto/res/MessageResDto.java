package com.implementacionbasedatos.ejercicio1.dto.res;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageResDto {
    String message;

    public MessageResDto(String message) {
        this.message = message;
    }

}
