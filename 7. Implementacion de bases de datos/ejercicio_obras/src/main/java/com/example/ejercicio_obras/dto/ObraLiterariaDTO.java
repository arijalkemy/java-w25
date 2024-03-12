package com.example.ejercicio_obras.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDTO {
    String nombre;
    String autor;
    Integer paginas;
    String editorial;
    Integer anio;
}
