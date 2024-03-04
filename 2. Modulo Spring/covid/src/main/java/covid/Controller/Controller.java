package covid.Controller;

import covid.DTO.PersonaDeRiesgoDTO;
import covid.Model.Sintoma;
import covid.Service.Servicios;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private final Servicios servicio;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptom() {
        return new ResponseEntity<List<Sintoma>>(servicio.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findByName(@PathVariable String name) {
        String existe = servicio.findByName(name);
        if(existe != null) {
            return new ResponseEntity<String>(servicio.findByName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("No se encontrò el sintoma...", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDeRiesgoDTO>> findRiskPerson() {
        return new ResponseEntity<List<PersonaDeRiesgoDTO>>(servicio.findRiskPerson(), HttpStatus.OK);
    }


}
