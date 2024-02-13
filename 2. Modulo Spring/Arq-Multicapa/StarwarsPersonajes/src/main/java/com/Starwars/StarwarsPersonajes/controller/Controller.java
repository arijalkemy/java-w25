package com.Starwars.StarwarsPersonajes.controller;

import com.Starwars.StarwarsPersonajes.dto.PersonajeDTO;
import com.Starwars.StarwarsPersonajes.service.StarwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    StarwarsService starwarsService;

    @GetMapping("/findCharacters/{name}")
    public ResponseEntity<List<PersonajeDTO>> findCharacters(@PathVariable String name){
        return new ResponseEntity<>(starwarsService.findCharacters(name), HttpStatus.OK);
    }
}
