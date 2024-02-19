package org.bootcamp.starwars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private String height;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;
}
