package com.codigoMorse.CodigoMorse.Controller;

import com.codigoMorse.CodigoMorse.Model.Deporte;
import com.codigoMorse.CodigoMorse.Model.DeportistaDTO;
import com.codigoMorse.CodigoMorse.Model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeportistaController {
    private List<Deporte> deportes = Arrays.asList(new Deporte("Fútbol", "Intermedio"), new Deporte("tenis", "Avanzado")
    );
    private List<Persona> personas = Arrays.asList(new Persona("Fran", "Lopez", 25), new Persona("Ana", "Gomez", 30)
    );

    @GetMapping("/findSport")
    public ResponseEntity<List<Deporte>> findSport() {
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        Deporte deporte = deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        if (deporte != null) {
            return new ResponseEntity<>("Nivel deporte " + name + "; " + deporte.getNivel(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontro el deporte " + name, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> deportistasDTO = personas.stream().map(persona -> new DeportistaDTO(persona.getNombre(), persona.getApellido(), getDeporte(persona))).collect(Collectors.toList());
        return  ResponseEntity.ok(deportistasDTO);
    }
    private String getDeporte(Persona persona) {
        return deportes.isEmpty() ? "Sin deporte" : deportes.get(1).getNombre();
    }
}
