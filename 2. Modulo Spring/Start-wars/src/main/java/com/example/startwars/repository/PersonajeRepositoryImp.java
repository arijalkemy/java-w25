package com.example.startwars.repository;

import com.example.startwars.entity.Personaje;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonajeRepositoryImp implements IRepository<Personaje> {

  private List<Personaje> personasList;

  public PersonajeRepositoryImp() {
    this.personasList = readJSON();
  }

  private List<Personaje> readJSON() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File file = new File("src/main/java/com/example/startwars/repositories/starwars.json");
      System.out.println(file.getAbsoluteFile());
      List<Personaje> personaList = objectMapper.readValue(file, new TypeReference<>(){});
      System.out.println("Nice2");

      // personasList.forEach(p -> System.out.println(p.getName()));

      return personaList;
    } catch (IOException e) {
      System.out.println("No se puedo leer el archivo..." + e);
      return null;
    }
  }

  @Override
  public List<Personaje> getAll() {
    return personasList;
  }
}
