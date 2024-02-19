package com.bootcamp.ejercicio_deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeportistaDto {
    private String nombre, apellido, deporte;
}
