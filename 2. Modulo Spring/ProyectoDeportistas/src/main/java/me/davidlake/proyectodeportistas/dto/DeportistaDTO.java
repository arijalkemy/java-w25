package me.davidlake.proyectodeportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
