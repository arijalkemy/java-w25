package com.example.DEPORTESFINAL.DTO;

import com.example.DEPORTESFINAL.Modelo.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO {
    private String Nombre;
    private String Apellido;
    private String Edad;
    private String nombreDeporte;
    private String dificultadDeporte;

}
