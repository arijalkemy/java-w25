package com.starwars.demo.dto;

import com.starwars.demo.entity.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDTO {
    private String name;
    private int height;
    private double mass;
    private String gender;
    private String homeWorld;
    private String species;



    public static PersonajeDTO fromPersonaje(Personaje personaje){
        return new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
    }


}

