package com.ejercicio.redirecciones2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LinkDTO {
    private Integer id;
    private String url;
    private String password;
    private Boolean status;
    private Integer counter = 0;
}
