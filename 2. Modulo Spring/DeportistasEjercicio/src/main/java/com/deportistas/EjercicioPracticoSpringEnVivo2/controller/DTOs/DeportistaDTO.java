package com.deportistas.EjercicioPracticoSpringEnVivo2.controller.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportistaDTO {

    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
