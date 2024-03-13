package com.prendas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaDto {
    String nombre;
    String tipo;
    String marca;
    String color;
    Integer cantidad;
    String talle;
    @JsonProperty("precio_venta")
    Double precioVenta;
}
/*
{
        "nombre": "Lacoste Air",
        "tipo": "Chomba",
        "marca": "Lacoste",
        "color": "Verde",
        "cantidad": 5,
        "talle": "M",
        "precio_venta": 100.0
}*/
