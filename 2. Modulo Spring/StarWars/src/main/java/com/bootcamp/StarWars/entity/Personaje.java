package com.bootcamp.StarWars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private Integer height, mass;
}
