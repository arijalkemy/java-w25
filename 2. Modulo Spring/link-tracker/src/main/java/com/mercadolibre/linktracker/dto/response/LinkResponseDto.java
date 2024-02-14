package com.mercadolibre.linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDto {
    private Integer id;
    private String url;
    private Integer count;
}
