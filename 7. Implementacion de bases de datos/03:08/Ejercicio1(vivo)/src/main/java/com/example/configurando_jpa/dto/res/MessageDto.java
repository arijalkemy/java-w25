package com.example.configurando_jpa.dto.res;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDto {
    String message;

    public MessageDto(String message) {
        this.message = message;
    }

}
