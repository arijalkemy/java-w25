package bootcamp.controllers;

import bootcamp.dto.response.DeportePersonaDTO;
import bootcamp.dto.response.DeportesDTO;
import bootcamp.dto.response.ListaDeportePersonaDTO;
import bootcamp.dto.response.NivelDeporteDTO;
import bootcamp.dto.request.NombreDeporteDTO;
import bootcamp.models.Deporte;
import bootcamp.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sports")
public class SportsController {
    private List<Persona> personaRepo;
    private List<Deporte> deporteRepo;
    public SportsController(){

        this.deporteRepo = new ArrayList<>(Arrays.asList(
                new Deporte("Futbol", "Medio"),
                new Deporte("Basquet", "Medio"),
                new Deporte("Voley", "Alto"),
                new Deporte("Esgrima", "Muy Alto")

        ));
        this.personaRepo = new ArrayList<>(Arrays.asList(
                new Persona("Juan", "Perez", 25, this.deporteRepo.get(0)),
                new Persona("Martin", "Sanchez", 32, this.deporteRepo.get(0)),
                new Persona("Pedro", "Gimenez", 13, this.deporteRepo.get(1)),
                new Persona("Jaime", "Lopez", 20, this.deporteRepo.get(3))

        ));
    }
    @GetMapping("/findSports")
    public ResponseEntity<DeportesDTO> findSports(){
        DeportesDTO deportesDTO = new DeportesDTO(this.deporteRepo);

        return new ResponseEntity<>(deportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<NivelDeporteDTO> findSportByName(@PathVariable("name") NombreDeporteDTO nombreDeporteDTO){
        Optional<Deporte> optDeporte = this.deporteRepo.stream()
                .filter(d -> d.getNombre().equals(nombreDeporteDTO.getNombre())).findFirst();

        if(optDeporte.isPresent()){
            NivelDeporteDTO nivelDeporteDTO = new NivelDeporteDTO(optDeporte.get().getNivel());
            return  new ResponseEntity<>(nivelDeporteDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<ListaDeportePersonaDTO> findSportsPersons(){
        ListaDeportePersonaDTO listaDeportePersonaDTO = new ListaDeportePersonaDTO(
                this.personaRepo.stream().map(p -> new DeportePersonaDTO(
                        p.getNombre(),p.getApellido(),p.getDeporte().getNombre())).toList());

        return new ResponseEntity<>(listaDeportePersonaDTO, HttpStatus.OK);
    }

}
