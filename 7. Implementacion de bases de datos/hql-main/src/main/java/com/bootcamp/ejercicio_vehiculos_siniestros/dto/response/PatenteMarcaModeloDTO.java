package com.bootcamp.ejercicio_vehiculos_siniestros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloDTO {
    private String patente;
    private String marca;

    private String modelo;
}
