package main.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.PersonajeDTO;
import main.service.PersonajeService;

@RestController
@RequestMapping("/api")
public class PersonajeController {
    private PersonajeService personajeService;

    public PersonajeController() {
        this.personajeService = new PersonajeService();
    }

    @GetMapping("/starwars/{name}")
    @ResponseBody
    public ResponseEntity<List<PersonajeDTO>> starWarsName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.starWarsName(name), HttpStatusCode.valueOf(200));
    }

}
