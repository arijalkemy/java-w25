package com.api_starwars.ejercicio_api_starwars.controller;

import com.api_starwars.ejercicio_api_starwars.dto.CharacterDTO;
import com.api_starwars.ejercicio_api_starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/{query}")
    public List<CharacterDTO> findCharacter(@PathVariable String query){
        return characterService.find(query);
    }
}
