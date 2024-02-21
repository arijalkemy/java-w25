package ejercicio.starwars.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonajeController {

    @GetMapping("/{character}")
    public ResponseEntity<?> findCharacters(@PathVariable String character) {
        //TODO generar DTO para el response
        return ResponseEntity.ok().body("ASD");
    }
}
