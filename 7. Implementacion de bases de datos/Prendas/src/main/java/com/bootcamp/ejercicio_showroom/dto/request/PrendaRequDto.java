package com.bootcamp.ejercicio_showroom.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaRequDto{
        String nombre;
        String tipo;
        String marca;
        String color;
        String talle;
        Integer cantidad;
        Double precio_venta;

}
