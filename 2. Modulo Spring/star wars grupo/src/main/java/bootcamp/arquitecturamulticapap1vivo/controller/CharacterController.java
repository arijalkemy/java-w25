package bootcamp.arquitecturamulticapap1vivo.controller;

import bootcamp.arquitecturamulticapap1vivo.dto.CharacterDto;
import bootcamp.arquitecturamulticapap1vivo.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDto>> getCharactersByName(@PathVariable String name) {
        return new ResponseEntity<>(characterService.getCharactersByName(name), HttpStatus.OK);
    }

}
