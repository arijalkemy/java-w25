package com.bootcamp.StarWars.service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.entity.Personaje;
import com.bootcamp.StarWars.repository.PersonajeRepositorioImp;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImp implements IPersonajeService{
    public PersonajeServiceImp() {

    }

    public List<PersonajeDTO> buscarPersonajesPorNombre(String nombre) throws FileNotFoundException {
        PersonajeRepositorioImp repo = new PersonajeRepositorioImp();

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
