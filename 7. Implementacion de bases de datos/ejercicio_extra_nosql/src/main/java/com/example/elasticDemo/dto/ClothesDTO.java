package com.example.elasticDemo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class ClothesDTO {
    String id;
    String nombre;
    String tipo;
    String marca;
    String color;
    Double talle;
    Integer cantidad;
    Double precio_venta;
}
