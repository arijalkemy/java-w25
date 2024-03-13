package com.bootcamp.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    private Integer annoFabricacion;
    private Integer ruedas;
}
