package com.showroomAPI.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaDto {

    String nombre;
    String tipo;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precio;

}
