package com.meli.athletes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    private String nombre;
    private String apellido;
    private SportNameDTO deporte;
}

