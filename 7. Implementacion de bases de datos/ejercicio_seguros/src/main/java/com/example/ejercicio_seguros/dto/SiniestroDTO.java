package com.example.ejercicio_seguros.dto;

import com.example.ejercicio_seguros.model.Vehiculo;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {
    private LocalDate fecha;
    private double perdidaEconomica;
}
