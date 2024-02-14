package com.clase08_02_24.ejercicio_deportes.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtletaDTO {
    String nombre;
    String apellido;
    String deporte_realizado;
}
