package com.example.ejercicio_lasPerlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoIdJoyaDTO {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
