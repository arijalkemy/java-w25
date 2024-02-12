package com.miprimerproyecto.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    String nombre;
    String apellido;
    Integer edad;
}
