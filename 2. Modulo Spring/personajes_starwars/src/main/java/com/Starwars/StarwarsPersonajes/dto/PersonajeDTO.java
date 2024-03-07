package com.Starwars.StarwarsPersonajes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {
    //Del personaje, se desea ver todos los atributos menos hairColor, skinColor, eyeColor y birthYear.
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
