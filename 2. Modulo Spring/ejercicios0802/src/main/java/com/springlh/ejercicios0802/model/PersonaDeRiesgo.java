package com.springlh.ejercicios0802.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeRiesgo {
    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;
}
