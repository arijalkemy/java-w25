package com.mercadolibre.linktracker.model;

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
    private Integer count = 0;

    public Link(String url, String password) {
        this.url= url;
        this.password = password;
    }
}
