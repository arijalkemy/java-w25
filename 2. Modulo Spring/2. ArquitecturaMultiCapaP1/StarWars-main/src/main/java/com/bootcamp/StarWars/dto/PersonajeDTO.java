package com.bootcamp.StarWars.dto;
import com.bootcamp.StarWars.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {
    private String name;
    private String height;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String species;


    public PersonajeDTO(Personaje personaje){
        this.name = personaje.getName();
        this.height= personaje.getHeight();
        this.birthYear= personaje.getBirth_year();
        this.gender = personaje.getGender();
        this.homeWorld= personaje.getHomeworld();
        this.species=personaje.getSpecies();

    }
}
