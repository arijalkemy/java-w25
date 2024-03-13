package com.bootcamp.hql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculoSiniestro {
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("perdida_total")
    private Double perdidaTotal;
}


