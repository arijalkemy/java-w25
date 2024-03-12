package com.example.demo.dto;

import com.example.demo.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class VehiculoSiniestroDto {
    PerdidaMayorADto listaVehiculos;
    Double totalSumaPerdidas;
}
