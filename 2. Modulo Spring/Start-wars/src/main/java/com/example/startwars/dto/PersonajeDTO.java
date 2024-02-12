package com.example.startwars.dto;

import com.example.startwars.entity.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDTO {
  private String name;
  private int height;
  private int mass;
  private String gender;
  private String homeworld;
  private String species;

  public PersonajeDTO(Personaje personaje) {
    this.name = personaje.getName();
    this.height = personaje.getHeight();
    this.mass = personaje.getHeight();
    this.gender = personaje.getGender();
    this.homeworld = personaje.getHomeworld();
    this.species = personaje.getSpecies();
  }
}
