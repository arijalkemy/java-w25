package com.implementacionbd.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculoSiniestroDTO {
    PerdidaMayorDTO listaVehiculos;
    Double totalSumaPerdidas;
}
