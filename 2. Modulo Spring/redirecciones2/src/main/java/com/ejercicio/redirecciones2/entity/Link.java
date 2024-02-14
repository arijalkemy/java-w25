package com.ejercicio.redirecciones2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Boolean status;
    private Integer counter = 0;
}
