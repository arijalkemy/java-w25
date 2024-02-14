package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarWarsController {

    private final StarWarsService starWarsService;

    @Autowired
    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/characters/{name}")
    public List<CharacterDTO> findAllCharacters(@PathVariable String name) {
        return starWarsService.findCharacters(name);
    }






}
