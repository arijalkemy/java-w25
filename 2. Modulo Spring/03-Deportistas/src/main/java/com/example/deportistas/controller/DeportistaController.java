package com.example.deportistas.controller;

import com.example.deportistas.dao.Deporte;
import com.example.deportistas.dao.Persona;
import com.example.deportistas.dto.PersonaDeportistaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deporte")
public class DeportistaController {

    public static List<Deporte> deportes = List.of(new Deporte("Natacion", "Alto"),new Deporte("Futbol","Alto"),new Deporte("Tiro con arco","medio"));
    public static List<Persona> personas = List.of(new Persona("Julian","Vargas",45,deportes.get(0)),new Persona("Andrea","López",23,deportes.get(1)),new Persona("Rick","Sanchez",60,deportes.get(2)));


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findAll(){

        return new ResponseEntity<>(deportes,HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findByName(@PathVariable String name ){

        Optional<Deporte> existe = deportes.stream()
                .filter(deporte -> deporte.getNombre().toLowerCase().equals(name.toLowerCase()))
                .findFirst();

        if (existe.isEmpty()) {
            return new ResponseEntity<>("No se encontro el deporte",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existe.get().getNivel(),HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDto>> findSportsPersons(){

        List<PersonaDeportistaDto> personasDeportistas = new ArrayList<>();

        if (personas.size() == 0){

            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        for (Persona persona: personas){
            PersonaDeportistaDto personaDeportista = new PersonaDeportistaDto();
            personaDeportista.setNombre(persona.getNombre());
            personaDeportista.setApellido(persona.getApellido());
            personaDeportista.setDeporte(persona.getDeporte().getNombre());

            personasDeportistas.add(personaDeportista);

        }

        return new ResponseEntity<>(personasDeportistas,HttpStatus.OK);
    }





}
