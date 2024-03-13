package com.mercadolibre.hql_seguro_autos.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateSiniestroDto {
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
}
