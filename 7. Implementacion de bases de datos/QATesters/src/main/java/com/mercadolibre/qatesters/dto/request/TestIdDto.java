package com.mercadolibre.qatesters.dto.request;

import lombok.Data;

@Data
public class TestIdDto {
    Long id;

    public TestIdDto() {
    }

    public TestIdDto(Long id) {
        this.id = id;
    }
}
