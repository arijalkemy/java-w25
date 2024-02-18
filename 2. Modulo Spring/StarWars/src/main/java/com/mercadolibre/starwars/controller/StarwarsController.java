package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolibre.starwars.service.StarWarsServiceImpl;

import java.util.List;

@RestController
public class StarwarsController {
    @GetMapping("/buscarPersonaje/{personaje}")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonaje(@PathVariable String personaje) {
        StarWarsServiceImpl starWarsService = new StarWarsServiceImpl();
        List<PersonajeDTO> listaPersonajes = starWarsService.searchCharacter(personaje);
        return new ResponseEntity<> (listaPersonajes, HttpStatus.OK);
    }
}
