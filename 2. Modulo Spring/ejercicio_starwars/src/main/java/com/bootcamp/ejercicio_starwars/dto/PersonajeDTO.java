package com.bootcamp.ejercicio_starwars.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {
    String name, gender, homeworld, species;
    int height, mass;
}
