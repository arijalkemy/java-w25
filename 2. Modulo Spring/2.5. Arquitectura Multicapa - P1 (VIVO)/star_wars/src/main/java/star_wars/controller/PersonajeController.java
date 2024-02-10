package star_wars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import star_wars.dto.PersonajeDTO;
import star_wars.service.IPersonajeService;
import star_wars.service.PersonajeServiceImpl;

import java.util.List;

@RestController
public class PersonajeController {

    private IPersonajeService personajeService;

    public PersonajeController(PersonajeServiceImpl personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajesByName(@PathVariable String name) {
        List<PersonajeDTO> response = personajeService.findPersonajesByName(name);
        return new ResponseEntity<>(response, response.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
