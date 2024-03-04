package org.example.starwars.controller;

import org.example.starwars.dto.CharacterDTO;
import org.example.starwars.dto.CharacterMapper;
import org.example.starwars.repository.ICharacterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("character")
public class CharacterController {

    private ICharacterRepository characterRepository;

    public CharacterController(ICharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAllByNameLike(@RequestParam String name){
        return ResponseEntity.ok(this.characterRepository.findAllByNameLike(name).stream()
                .map(character -> CharacterMapper.getCharacterDTO(character)).toList());
    }
}
