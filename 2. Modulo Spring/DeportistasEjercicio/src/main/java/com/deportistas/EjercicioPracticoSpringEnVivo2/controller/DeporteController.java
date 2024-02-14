package com.deportistas.EjercicioPracticoSpringEnVivo2.controller;


import com.deportistas.EjercicioPracticoSpringEnVivo2.model.Deporte;
import com.deportistas.EjercicioPracticoSpringEnVivo2.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    private DeporteService deporteService = new DeporteService();

    @GetMapping("/obtenerLista")
    public ResponseEntity<List<Deporte>> getDeportes(){
        return new ResponseEntity<>(deporteService.returnDeportes(), HttpStatus.OK);
    }

    @GetMapping("/obtenerNivel/{nombre}")
    public ResponseEntity<Integer> getNivelDeporte(@PathVariable String nombre){

        Integer nivel = deporteService.existsDeporte(nombre);
        if(nivel!=0){
            return new ResponseEntity<>(nivel,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
