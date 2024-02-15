package com.springlh.ejercicios0802.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeportista {
    private String nombre;
    private String apellido;
    private String deporte;
}
