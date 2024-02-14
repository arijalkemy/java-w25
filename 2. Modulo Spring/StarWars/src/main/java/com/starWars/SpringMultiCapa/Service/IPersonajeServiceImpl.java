package com.starWars.SpringMultiCapa.Service;

import com.starWars.SpringMultiCapa.Controller.DTOs.PersonajeDTO;
import com.starWars.SpringMultiCapa.Model.Personaje;
import com.starWars.SpringMultiCapa.Repository.PersonajeRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class IPersonajeServiceImpl implements IPersonajeService {


    @Override
    public List<PersonajeDTO> obtenerPersonajes(String nombre) throws FileNotFoundException {
        List<PersonajeDTO> personajesResponse = new ArrayList<>();
        List<Personaje> personajes = PersonajeRepository.leerArchivoJson();

        personajes = personajes.stream()
                .filter(pj -> pj.getName().contains(nombre))
                .toList();
        for(Personaje pj : personajes) {
            personajesResponse.add(new PersonajeDTO(pj.getName(),pj.getHeight(), pj.getMass(),
                    pj.getGender(),pj.getHomeworld(),pj.getSpecies()));
        }
        return personajesResponse;
    }

    /*public static void main(String[] args) {
            try {
                List<Personaje> personajes = PersonajeRepository.leerArchivoJson();

                for (Personaje pj : personajes) {
                    System.out.println(pj.getName());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }*/

}
