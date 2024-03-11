package com.mercadolibre.qatesters.dto;

import lombok.Data;

@Data
public class MessageDto {
    String message;

    public MessageDto(String message) {
        this.message = message;
    }
}
