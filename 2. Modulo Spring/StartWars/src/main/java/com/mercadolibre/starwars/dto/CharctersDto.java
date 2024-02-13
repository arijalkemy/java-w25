package com.mercadolibre.starwars.dto;

import com.mercadolibre.starwars.base.Characters;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharctersDto {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharctersDto(Characters characters) {
        this.name = characters.getName();
        this.height = characters.getHeight();
        this.mass = characters.getMass();
        this.gender = characters.getGender();
        this.homeworld = characters.getHomeworld();
        this.species = characters.getSpecies();
    }
}
