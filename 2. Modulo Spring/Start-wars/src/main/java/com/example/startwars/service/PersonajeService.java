package com.example.startwars.service;

import com.example.startwars.dto.PersonajeDTO;
import com.example.startwars.entity.Personaje;
import com.example.startwars.repository.PersonajeRepositoryImp;
import com.example.startwars.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService {
  private IRepository<Personaje> personajeRepository;

  public PersonajeService() {
    this.personajeRepository = new PersonajeRepositoryImp();
  }

  public List<PersonajeDTO> get(String busqueda) {
    List<Personaje> personajes = personajeRepository.getAll();

    List<PersonajeDTO> personajesFiltrados = new ArrayList<>();
    personajes.stream()
        .filter(p -> p.getName().contains(busqueda))
        .forEach(p -> personajesFiltrados.add(new PersonajeDTO(p)));

    return personajesFiltrados;
  }

}
