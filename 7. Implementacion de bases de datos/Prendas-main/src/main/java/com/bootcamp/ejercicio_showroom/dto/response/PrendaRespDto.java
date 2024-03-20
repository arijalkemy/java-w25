package com.bootcamp.ejercicio_showroom.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaRespDto{
        Long codigo;
        String nombre;
        String tipo;
        String marca;
        String color;
        String talle;
        Integer cantidad;
        Double precio_venta;

}
