package PersonajeStarWars.controller;

import PersonajeStarWars.dto.DtoPersonaje;
import PersonajeStarWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/StarWars")
public class StarWarsController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping("/findPersonaje/{nombre}")
    @ResponseBody
    public List<DtoPersonaje> getPersonajes(@PathVariable String nombre){
        return personajeService.getDtoPersonajes(nombre);
    }
}
