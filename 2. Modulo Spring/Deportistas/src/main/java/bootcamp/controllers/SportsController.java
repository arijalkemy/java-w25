package bootcamp.controllers;

import bootcamp.dto.response.DeportePersonaDTO;
import bootcamp.models.Deporte;
import bootcamp.repositories.DeporteRepository;
import bootcamp.repositories.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sports")
public class SportsController {

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){

        return new ResponseEntity<>(DeporteRepository.listaDeporte, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable("name") String nombreDeporte){
        Optional<Deporte> optDeporte = DeporteRepository.listaDeporte.stream()
                .filter(d -> d.getNombre()
                        .equalsIgnoreCase(nombreDeporte)).findFirst();
        return optDeporte.isPresent() ?
                new ResponseEntity<>(optDeporte.get().getNivel(), HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportePersonaDTO>> findSportsPersons(){
        List<DeportePersonaDTO> listaDeportePersonaDTO =
                PersonaRepository.listaPersonas.stream().map(p -> new DeportePersonaDTO(
                        p.getNombre(),p.getApellido(),p.getDeporte().getNombre())).toList();

        return new ResponseEntity<>(listaDeportePersonaDTO, HttpStatus.OK);
    }

}
