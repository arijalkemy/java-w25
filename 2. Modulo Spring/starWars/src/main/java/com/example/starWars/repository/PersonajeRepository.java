package com.example.starWars.repository;

import com.example.starWars.dto.PersonajeDTO;
import com.example.starWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    private List<PersonajeDTO> personajes;

    @PostConstruct
    public void cargarDatos(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<PersonajeDTO>> tipoReferencia = new TypeReference<List<PersonajeDTO>>() {};
            InputStream inputStream = getClass().getResourceAsStream("/starwars.json");
            personajes = mapper.readValue(inputStream, tipoReferencia);
        } catch (IOException e) {
            e.printStackTrace();
            personajes = new ArrayList<>();
        }
    }

    public List<PersonajeDTO> buscarNombre(String name){
        List<PersonajeDTO> resultado = personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        return resultado;    }
}
