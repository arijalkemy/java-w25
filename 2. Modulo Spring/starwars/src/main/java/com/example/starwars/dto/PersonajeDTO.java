package com.example.starwars.dto;

import com.example.starwars.model.Personaje;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonajeDTO {
     String name;
     String height;
     String mass;
     String gender;
     String homeWorld;
     String species;

   public  PersonajeDTO(Personaje personaje){
        this.name = personaje.getName();
        this.height= personaje.getHeight();
        this.species = personaje.getSpecies();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeWorld = personaje.getHomeWorld();
   }

}
