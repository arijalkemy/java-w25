package com.bootcamp.ejercicio_consultas_HQL.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResSiniestroDTO {
    private Long id;
    private LocalDate fecha;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
    @JsonProperty("vehiculo_id")
    private Long vehiculoId;
}
