package com.mercadolibre.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Integer visitCount = 0;
    private Boolean isValid = Boolean.TRUE;
}
