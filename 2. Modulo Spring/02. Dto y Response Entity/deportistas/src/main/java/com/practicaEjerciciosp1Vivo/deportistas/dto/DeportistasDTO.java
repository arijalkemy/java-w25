package com.practicaEjerciciosp1Vivo.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportistasDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
