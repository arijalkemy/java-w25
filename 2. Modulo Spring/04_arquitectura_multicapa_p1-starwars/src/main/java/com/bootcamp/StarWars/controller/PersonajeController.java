package com.bootcamp.StarWars.controller;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.service.IPersonajeService;
import com.bootcamp.StarWars.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService servicio;

    public PersonajeController(PersonajeServiceImp servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/personajes")
    public ResponseEntity<?> personajes(@RequestParam(defaultValue = "") String nombre) throws FileNotFoundException {
        List<PersonajeDTO> listaPersonajes = servicio.buscarPersonajesPorNombre(nombre);
        return listaPersonajes.isEmpty()
                ? new ResponseEntity<>("No se encontró al personaje.", HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(listaPersonajes, HttpStatus.OK);
    }
}
