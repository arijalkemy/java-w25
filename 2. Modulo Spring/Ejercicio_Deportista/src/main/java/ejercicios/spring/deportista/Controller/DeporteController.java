package ejercicios.spring.deportista.Controller;

import ejercicios.spring.deportista.DTO.DeporteDTO;
import ejercicios.spring.deportista.DTO.DeportistaDTO;
import ejercicios.spring.deportista.DTO.ResponseDTO;
import ejercicios.spring.deportista.DTO.SingleSportDTO;
import ejercicios.spring.deportista.Model.Deporte;
import ejercicios.spring.deportista.Model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    private List<Deporte> listaDeps;
    private List<Persona> listaPers;

    @GetMapping("/findSports")
    public ResponseEntity<DeporteDTO> findSports() {
        DeporteDTO depDTO = loadDTO();
        return new ResponseEntity<>(depDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findByName(@PathVariable String name) {
        listaDeps = loadSports();
        String nivel = listaDeps.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst().get().getNivel();
        return new ResponseEntity<>(nivel, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> listaPers = loadPersDto();
        return new ResponseEntity<>(loadPersDto(), HttpStatus.OK);
    }

    private List<DeportistaDTO> loadPersDto() {
        List<DeportistaDTO> listaPersDto = new ArrayList<>();
        listaPers = loadPersonas();

        for(Persona p : listaPers) {
            listaPersDto.add(new DeportistaDTO(p.getNombre(), p.getNombreDeporte()));
        }

        return listaPersDto;
    }

    @PostMapping("/saveSport")
    public ResponseEntity<?> saveSports(@RequestBody SingleSportDTO singleSportDto) {
        return new ResponseEntity<>(new ResponseDTO("Se guardó."), HttpStatus.OK);
    }

    private DeporteDTO loadDTO() {
        return new DeporteDTO(loadSports(), "Todo en orden.");
    }

    private List<Persona> loadPersonas() {
        listaDeps = loadSports();
        return List.of(new Persona("Juan Manuel", 27, listaDeps.get(0)), new Persona("Nicolas", 25, listaDeps.get(1)));
    }

    private List<Deporte> loadSports() {
        listaDeps = List.of(new Deporte("Tenis", "Medio"), new Deporte("Futbol", "Facil"), new Deporte("Voley", "Avanzado"));
        return listaDeps;
    }

}
