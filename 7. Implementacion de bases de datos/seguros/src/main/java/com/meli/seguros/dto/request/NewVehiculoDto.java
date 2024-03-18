package com.meli.seguros.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewVehiculoDto {
    String patente;
    String marca;
    String modelo;
    @JsonProperty("anio_fabricacion")
    Integer anioFabricacion;
    @JsonProperty("cantidad_ruedas")
    Integer cantidadRuedas;
}
