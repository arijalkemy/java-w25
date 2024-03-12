package com.mercadolibre.testerapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private String message;
    private String description;
}
