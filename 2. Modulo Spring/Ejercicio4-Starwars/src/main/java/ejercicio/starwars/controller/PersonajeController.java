package ejercicio.starwars.controller;

import ejercicio.starwars.dto.PersonajeDTO;
import ejercicio.starwars.service.PersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class PersonajeController {

    PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{character}")
    public ResponseEntity<?> findCharacters(@PathVariable String character) {
        List<PersonajeDTO> personajes;
        try {
            personajes = personajeService.getCharacter(character);
        } catch(RuntimeException e){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personajes);
    }
}
