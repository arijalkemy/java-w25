package com.miprimerproyecto.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AthleteDTO {
    String nombre;
    String apellido;
    String sport;
}
