package com.bootcamp.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDTO {
    private String name, gender, homeworld, species;
    private Integer height, mass;
}
