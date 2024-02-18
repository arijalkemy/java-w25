package com.example.DEPORTESFINAL.Controller;

import com.example.DEPORTESFINAL.DTO.PersonaDTO;
import com.example.DEPORTESFINAL.Modelo.Deporte;
import com.example.DEPORTESFINAL.Modelo.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controler {
    List<Deporte> sportsList = List.of(new Deporte("futbol","alto")
            ,new Deporte("sledding","medio")
            ,new Deporte("golf","bajo"));

    List<Persona> personList = List.of(new Persona("Tom","Brady", "44"),
            new Persona("Lionel","Messi","36"),
            new Persona("Tiger", "Woods","39"));

    @GetMapping("/getAll")
    public ResponseEntity<List<Deporte>> verDeportes(){
        return new ResponseEntity<> (sportsList, HttpStatus.OK);

    }

    @GetMapping("/finSport/{nombre}")
    public ResponseEntity<String> buscarDificultad(@PathVariable String nombre){
        for (Deporte d:sportsList){
            if(d.getNombre().equals(nombre)){
                return new ResponseEntity<> (d.getNivel(), HttpStatus.OK);
            }


        }
        return new ResponseEntity<> ("No existe deporte con ese nombre", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<PersonaDTO>> encontarDeportistas(){

        List<PersonaDTO>  personas = new ArrayList<>();

        for (Deporte deport: sportsList){

            for(Persona person: personList){
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setNombre(person.getNombre());
                personaDTO.setEdad(person.getEdad());
                personaDTO.setApellido(person.getApellido());
                personaDTO.setNombreDeporte(deport.getNombre());
                personaDTO.setDificultadDeporte(deport.getNivel());
                personas.add(personaDTO);

            }
        }
    return new ResponseEntity<>(personas, HttpStatus.OK);
    }




}
