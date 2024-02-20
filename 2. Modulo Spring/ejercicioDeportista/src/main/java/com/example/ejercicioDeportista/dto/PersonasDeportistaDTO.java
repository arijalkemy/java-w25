package com.example.ejercicioDeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonasDeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
