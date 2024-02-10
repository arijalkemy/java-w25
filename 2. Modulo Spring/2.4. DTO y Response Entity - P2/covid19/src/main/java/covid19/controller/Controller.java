package covid19.controller;

import covid19.dto.PersonaDTO;
import covid19.dto.SintomaDTO;
import covid19.model.Persona;
import covid19.model.Sintoma;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/findSymptom")
    public ResponseEntity<List<String>> getSymptoms() {
        List<String> response = new ArrayList<>();
        for (Sintoma sintoma : Sintoma.sintomas) {
            response.add(sintoma.getNombre());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getSymptomByName(@PathVariable String name) {
        Sintoma entity = Sintoma.sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(name)).findFirst().orElse(null);
        if (entity != null) {
            return new ResponseEntity<>(new SintomaDTO(entity.getNombre(), entity.getNivelDeGravedad()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> getRiskPerson() {
        List<PersonaDTO> response = new ArrayList<>();
        for (Persona persona : Persona.personas) {
            if (persona.getSintomas().size() > 0 && persona.getEdad() > 60) {
                response.add(new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getSintomas()));
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}