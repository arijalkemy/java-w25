package com.example.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private NombreDeporteDTO deporte;
}
