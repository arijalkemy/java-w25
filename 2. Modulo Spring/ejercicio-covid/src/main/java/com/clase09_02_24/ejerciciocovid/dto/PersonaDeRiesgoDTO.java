package com.clase09_02_24.ejerciciocovid.dto;

import com.clase09_02_24.ejerciciocovid.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data@AllArgsConstructor
public class PersonaDeRiesgoDTO {
    String nombre;
    String apellido;
    Integer edad;
    List<Sintoma> sintomas;
}
