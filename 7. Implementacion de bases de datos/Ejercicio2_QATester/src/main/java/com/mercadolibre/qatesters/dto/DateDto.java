package com.mercadolibre.qatesters.dto;

import lombok.Data;

@Data
public class DateDto {
    String date;

    public DateDto() {
    }

    public DateDto(String date) {
        this.date = date;
    }
}
