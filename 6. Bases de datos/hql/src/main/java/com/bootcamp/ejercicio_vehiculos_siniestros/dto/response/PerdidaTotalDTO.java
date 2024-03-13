package com.bootcamp.ejercicio_vehiculos_siniestros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerdidaTotalDTO {
    private PatenteMarcaModeloDTO patenteMarcaModelo;
    private double perdidaTotal;
}
