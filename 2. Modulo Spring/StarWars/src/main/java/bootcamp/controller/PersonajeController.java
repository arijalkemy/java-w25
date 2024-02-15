package bootcamp.controller;

import bootcamp.dto.PersonajeDTO;
import bootcamp.model.Personaje;
import bootcamp.repository.PersonajeRepo;
import bootcamp.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<Personaje>> findAll(@PathVariable String name){
        return new ResponseEntity<>(personajeService.findByName(name), HttpStatus.OK);
    }
}
