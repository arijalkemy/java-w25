package com.implementacionbd.ejercicio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaDTO {

    String nombre;

    String tipo;

    String marca;

    String color;

    String talle;

    Integer cantidad;

    @JsonProperty("precio_venta")
    Double precioVenta;

}
