package com.mercadolibre.qatesters.dto;

import lombok.Data;

@Data
public class ExceptionDto {
    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }
}