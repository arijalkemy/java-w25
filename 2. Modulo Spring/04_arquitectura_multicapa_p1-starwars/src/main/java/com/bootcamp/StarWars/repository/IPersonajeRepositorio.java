package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public interface IPersonajeRepositorio {

  private List<Personaje> cargarLista() {
    return null;
  }

  public List<Personaje> getPersonajes();
}
