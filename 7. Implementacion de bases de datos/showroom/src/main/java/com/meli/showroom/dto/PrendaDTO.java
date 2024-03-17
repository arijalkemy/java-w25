package com.meli.showroom.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaDTO {

    String nombre;
    String tipo;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precio_venta;
}
