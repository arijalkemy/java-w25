package com.bootcamp.Deportistas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Deportista {
    private String nombre;
    private String apellido;
    private String deporte;
}
