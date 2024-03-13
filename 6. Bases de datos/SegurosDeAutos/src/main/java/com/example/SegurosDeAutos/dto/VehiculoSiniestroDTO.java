package com.example.SegurosDeAutos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantRuedas;
}
