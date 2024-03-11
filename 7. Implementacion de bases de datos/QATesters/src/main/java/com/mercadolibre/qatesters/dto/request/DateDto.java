package com.mercadolibre.qatesters.dto.request;

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
