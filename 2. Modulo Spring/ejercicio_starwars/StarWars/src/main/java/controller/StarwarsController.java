package controller;

import dto.PersonajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.StarWarsServiceImpl;

import java.util.List;

@RestController
public class StarwarsController {
    @GetMapping("/buscarPersonaje")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonaje(String personaje) {
        StarWarsServiceImpl starWarsService = new StarWarsServiceImpl();
        List<PersonajeDTO> listaPersonajes = starWarsService.searchCharacter(personaje);
        return new ResponseEntity<> (listaPersonajes, HttpStatus.OK);
    }
}
