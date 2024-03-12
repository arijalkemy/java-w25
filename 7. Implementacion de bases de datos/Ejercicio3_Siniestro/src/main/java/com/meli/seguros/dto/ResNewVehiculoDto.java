package com.meli.seguros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResNewVehiculoDto {
    Long id;
    String patente;
    String marca;
    String modelo;
    @JsonProperty("anio_fabricacion")
    Integer anioFabricacion;
    @JsonProperty("cantidad_ruedas")
    Integer cantidadRuedas;
}
