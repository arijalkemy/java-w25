package com.starWars.SpringMultiCapa.Controller;

import com.starWars.SpringMultiCapa.Controller.DTOs.PersonajeDTO;
import com.starWars.SpringMultiCapa.Service.IPersonajeService;
import com.starWars.SpringMultiCapa.Service.IPersonajeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/starwars")
public class PersonajeController {

    private IPersonajeService IPersonajeService = new IPersonajeServiceImpl();

    @GetMapping("/buscar")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@RequestParam(defaultValue = "") String nombre) throws FileNotFoundException {

        List<PersonajeDTO> personajeDTOs = IPersonajeService.obtenerPersonajes(nombre);
        if(personajeDTOs.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .body(IPersonajeService.obtenerPersonajes(nombre));
    }
}
