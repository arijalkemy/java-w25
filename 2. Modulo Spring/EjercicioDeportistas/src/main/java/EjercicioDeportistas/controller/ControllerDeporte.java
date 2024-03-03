package EjercicioDeportistas.controller;

import EjercicioDeportistas.dto.DtoDeportistas;
import EjercicioDeportistas.models.Deporte;
import EjercicioDeportistas.models.Persona;
import EjercicioDeportistas.service.DeporteService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/deportes")
public class ControllerDeporte {

    @GetMapping(path="/findSports")
    @ResponseBody
    public List<Deporte> getDeportes(){
        DeporteService deportes = new DeporteService();
        return deportes.getDeportesList();
    }

    @GetMapping("/findSports/{nombre}")
    public String getNivelDeporte(@PathVariable String nombre){
        DeporteService deportes = new DeporteService();
        Optional<String> nivelDeporte = deportes.getDeportesList().stream()
                .filter( deporte -> deporte.getNombre().equals(nombre))
                .map(Deporte::getNivel)
                .findFirst();

        String nivel = nivelDeporte.orElse("Nivel no encontrado");
        return "El nivel de " + nombre + " es: " + nivel;
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<DtoDeportistas> getDeportistas(){
        DeporteService service = new DeporteService();
        List<Persona> personas = service.getPersonasList();
        List<Deporte> deportes = service.getDeportesList();

        List<DtoDeportistas> deportistas = List.of(
                new DtoDeportistas(personas.get(0).getNombre(),deportes.get(3).getNombre()),
                new DtoDeportistas(personas.get(1).getNombre(),deportes.get(4).getNombre()),
                new DtoDeportistas(personas.get(2).getNombre(),deportes.get(1).getNombre()),
                new DtoDeportistas(personas.get(3).getNombre(),deportes.get(2).getNombre()));
        return deportistas;
    }

}
