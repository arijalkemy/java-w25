package com.deportistas.EjercicioPracticoSpringEnVivo2.controller;


import com.deportistas.EjercicioPracticoSpringEnVivo2.controller.DTOs.DeportistaDTO;
import com.deportistas.EjercicioPracticoSpringEnVivo2.service.DeportistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deportista")
public class DeportistaController {

    private DeportistaService deportistaService = new DeportistaService();


    @GetMapping("/obtenerLista")
    public ResponseEntity<List<DeportistaDTO>> obtenerDeportistas(){
        return new ResponseEntity<>(
                deportistaService.findDeportistas(),
                HttpStatus.OK
        );
    }

}
