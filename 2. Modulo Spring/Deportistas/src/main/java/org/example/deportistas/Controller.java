package org.example.deportistas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping ("/findSports")
    public ResponseEntity<List<Deporte>> deportes(){
        List<Deporte> l = new ArrayList<>();
        l.addAll(List.of(new Deporte("futbol", "principiante"),
                new Deporte("futbol", "avanzado"),
                new Deporte("baloncesto","intermedio")));

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping ("/findSport/{nombre}")
    public ResponseEntity<String> encontrar(@PathVariable String nombre){
        List<Deporte> l = new ArrayList<>();
        l.addAll(List.of(new Deporte("futbol", "principiante"),
                new Deporte("futbol", "avanzado"),
                new Deporte("baloncesto","intermedio")));

        Deporte w = l.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().get();
        return new ResponseEntity<>(w.getNivel(), HttpStatus.OK);
    }

    @GetMapping ("/findSportsPersons")
    public ResponseEntity<List<dto>> personas(){
        List<Persona> l = new ArrayList<>();
        l.add(new Persona("Juan","Zapata", 21, new Deporte("futbol", "avanzado")));
        l.add(new Persona("Nicolas", "Villa", 21, new Deporte("Tennis", "Intermedio")));

        return new ResponseEntity<>(l.stream().map(x -> new dto(x.getNombre(),x.getApellido(), x.getDeporte().getNombre())).toList(), HttpStatus.OK);
    }
}
