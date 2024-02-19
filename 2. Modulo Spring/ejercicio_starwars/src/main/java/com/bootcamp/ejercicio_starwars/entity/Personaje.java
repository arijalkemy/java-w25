package com.bootcamp.ejercicio_starwars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    String name, gender, homeworld, species;
    @JsonProperty("hair_color")
    String hairColor;
    @JsonProperty("skin_color")
    String skinColor;
    @JsonProperty("eye_color")
    String eyeColor;
    @JsonProperty("birth_year")
    String birthYear;
    int height, mass;
}
