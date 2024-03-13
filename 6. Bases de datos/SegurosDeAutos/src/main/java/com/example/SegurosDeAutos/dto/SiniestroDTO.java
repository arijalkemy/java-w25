package com.example.SegurosDeAutos.dto;

import com.example.SegurosDeAutos.entity.Vehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private VehiculoSiniestroDTO vehiculo;
}
