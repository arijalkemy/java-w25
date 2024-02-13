package com.bootcamp.StarWars.service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.entity.Personaje;
import com.bootcamp.StarWars.repository.PersonajeRepositorio;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService {
    public List<PersonajeDTO> buscarNombre(String nombre) throws FileNotFoundException {
        PersonajeRepositorio repo = new PersonajeRepositorio();

        List<Personaje> listaPersonajes = repo.getPersonajes()
                .stream().filter(p -> p.getName().contains(nombre)).toList();

        List<PersonajeDTO> listaDtos = new ArrayList<>();

        for(Personaje p : listaPersonajes) {
            listaDtos.add(new PersonajeDTO(p.getName(), p.getGender(),
                    p.getHomeworld(), p.getSpecies(), p.getHeight(), p.getMass()));
        }

        return listaDtos;
    }
}
