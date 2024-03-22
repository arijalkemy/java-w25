package com.relations.relations.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestProductoDto {
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private Boolean disponible;
}
