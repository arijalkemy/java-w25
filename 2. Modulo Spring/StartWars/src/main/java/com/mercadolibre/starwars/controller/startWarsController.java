package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharctersDto;
import com.mercadolibre.starwars.repository.CharacterRepoImp;
import com.mercadolibre.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolibre.starwars.base.Characters;

import java.util.List;

@RestController

public class startWarsController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/find")
    public ResponseEntity<List<CharctersDto>> findByName(@RequestParam String name) {

        return new ResponseEntity<>(this.characterService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharctersDto>> findAll(){

        return new ResponseEntity<>(this.characterService.findAll(), HttpStatus.OK);
    }
}
