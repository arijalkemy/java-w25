package com.example.starWars.controller;

import com.example.starWars.dto.PersonajeDTO;
import com.example.starWars.entity.Personaje;
import com.example.starWars.service.BuscarNombreImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    private final BuscarNombreImpl buscarNombres;

    public PersonajeController(BuscarNombreImpl buscarNombres) {
        this.buscarNombres = buscarNombres;
    }

    @GetMapping("/buscar/{name}")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonajes(@PathVariable String name){
        List<PersonajeDTO> personajeEncontrado = buscarNombres.BuscarPersonaje(name);
        System.out.println("********"  + personajeEncontrado);
        return ResponseEntity.ok(personajeEncontrado);
    }
}
