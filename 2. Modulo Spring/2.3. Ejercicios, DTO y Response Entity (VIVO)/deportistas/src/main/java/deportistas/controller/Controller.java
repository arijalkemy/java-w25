package deportistas.controller;

import deportistas.dto.DeporteDTO;
import deportistas.dto.DeportistaDTO;
import deportistas.model.Deporte;
import deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    public static List<Deporte> deportes = new ArrayList<>() {{
        add(new Deporte("Futbol", 1, new ArrayList<>() {{
                add(new Persona("Juan", "Perez", 20));
                add(new Persona("Pedro", "Gomez", 30));
            }}
        ));
        add(new Deporte("Tenis", 2, new ArrayList<>() {{
                add(new Persona("Maria", "Gomez", 25));
                add(new Persona("Juana", "Perez", 35));
            }}
        ));
        add(new Deporte("Natacion", 3, new ArrayList<>() {{
                add(new Persona("Jose", "Gomez", 30));
                add(new Persona("Jorge", "Perez", 40));
            }}
        ));
        add(new Deporte("Atletismo", 4, new ArrayList<>() {{
                add(new Persona("Ana", "Gomez", 35));
                add(new Persona("Julia", "Perez", 45));
            }}
        ));
        add(new Deporte("Boxeo", 5, new ArrayList<>() {{
                add(new Persona("Luis", "Gomez", 40));
                add(new Persona("Luisa", "Perez", 50));
            }}
        ));
    }};

    @GetMapping("/findSports")
    public ResponseEntity<List<String>> getDeportes() {
        List<String> response = new ArrayList<>();
        for (Deporte deporte : deportes) {
            response.add(deporte.getNombre());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> getDeporte(@PathVariable String name) {
        Deporte entity = deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().orElse(null);
        if (entity != null) {
            DeporteDTO response = new DeporteDTO(entity.getNombre(), entity.getNivel());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getDeportistas() {
        List<DeportistaDTO> response = new ArrayList<>();
        for (Deporte deporte : deportes) {
            for (Persona persona : deporte.getDeportistas()) {
                response.add(new DeportistaDTO(persona.getNombre(), persona.getApellido(), deporte.getNombre()));
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}