package org.example.starwars.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterModel {
    private String name;
    private double height;
    private double mass;
    @JsonProperty("hair_color")
    String hairColor;
    @JsonProperty("skin_color")
    String skinColor;
    @JsonProperty("eye_color")
    String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}