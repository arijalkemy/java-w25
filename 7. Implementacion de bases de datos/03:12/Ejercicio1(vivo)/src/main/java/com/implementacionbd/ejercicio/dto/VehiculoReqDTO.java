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
public class VehiculoReqDTO {

    private String patente;

    private String marca;

    @JsonProperty("anyo_fabricacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate anyoFabricacion;

    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;

    private String modelo;
}
