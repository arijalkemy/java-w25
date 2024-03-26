package com.example.SegurosDeAutos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSiniestroDTO {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private Long idVehiculo;
}
