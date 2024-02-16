package com.bootcamp.ejercicio_deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteDto {
    private String nombre, nivel;
}