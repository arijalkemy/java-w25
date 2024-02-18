package com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTO {
    private Integer id;
    private String url;
    private String password;
    private Integer visitCount;
    private Boolean isValid;
}
