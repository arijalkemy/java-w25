package org.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.service.CharacterService;

import javax.swing.text.html.HTML;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {
    @Autowired
    private CharacterService service;


    @GetMapping("/findCharacter/{name}")
    public ResponseEntity<?> findCharacter(@PathVariable String name){
        service = new CharacterService();
        return new ResponseEntity<>(service.findCharacter(name), HttpStatus.OK);
    }
}
