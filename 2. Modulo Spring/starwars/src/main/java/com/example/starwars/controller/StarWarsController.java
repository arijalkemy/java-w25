package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IStarwarsService;
import com.example.starwars.service.StarwarsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/starWars")
public class StarWarsController {

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> findPersonajeByName(@PathVariable String name){
        IStarwarsService starwarsService = new StarwarsServiceImpl();
        return ResponseEntity.ok().body(starwarsService.findByName(name));
    }
}
