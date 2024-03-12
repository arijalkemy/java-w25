package com.implementacionbd.ejercicio.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SiniestroReqDTO {
    @JsonProperty("fecha_siniestro")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSiniestro;

    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
}
