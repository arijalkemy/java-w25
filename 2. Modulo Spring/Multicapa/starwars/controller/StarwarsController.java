package controller;

import service.PersonajeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StarwarsController {

    @GetMapping("/personajes/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajesPorNombre(@PathVariable String nombre){
        PersonajeService service = new PersonajeService();
        List<PersonajeDTO> personajes;
        try{
            personajes = service.obtenerPersonajesPorNombre(nombre);
        }catch(RuntimeException e){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personajes);
    }
}
