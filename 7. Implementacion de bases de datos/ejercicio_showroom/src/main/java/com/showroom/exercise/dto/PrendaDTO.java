package com.showroom.exercise.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaDTO {
    String nombre;
    String tipo;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precioVenta;
}
