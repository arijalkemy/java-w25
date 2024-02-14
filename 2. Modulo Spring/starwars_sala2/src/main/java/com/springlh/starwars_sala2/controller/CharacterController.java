package com.springlh.starwars_sala2.controller;

import com.springlh.starwars_sala2.dto.CharacterDTO;
import com.springlh.starwars_sala2.service.CharacterService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaje")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacterController {

    final
    CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }


    @GetMapping("/findCharacter")
    public ResponseEntity<List<CharacterDTO>> characterDTO(@RequestParam(name = "name") String name) {

        return ResponseEntity.ok()
                .body(this.characterService.findByName(name));

    }
}
