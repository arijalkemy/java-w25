package com.bootcamp.ejercicio_consultas_HQL.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSiniestroDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
    @JsonProperty("vehiculo_id")
    private Long vehiculoId;
}
