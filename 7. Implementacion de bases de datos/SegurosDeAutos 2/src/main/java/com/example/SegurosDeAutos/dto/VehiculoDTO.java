package com.example.SegurosDeAutos.dto;

import com.example.SegurosDeAutos.entity.Siniestro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantRuedas;
    private List<SiniestroVehiculoDTO> siniestros;
}
