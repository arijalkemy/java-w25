package main.controller;

import lombok.AllArgsConstructor;
import main.dto.PersonajeDTO;
import main.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    IPersonajeService personajeService;

    @GetMapping("/searchCharacters/{character}")
    public ResponseEntity<List<PersonajeDTO>> searchCharacters (@PathVariable String character){
        return new ResponseEntity<>(personajeService.searchCharacter(character), HttpStatus.OK);
    }
}
