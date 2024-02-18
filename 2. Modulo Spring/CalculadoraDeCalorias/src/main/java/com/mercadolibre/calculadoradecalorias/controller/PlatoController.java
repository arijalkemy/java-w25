package com.mercadolibre.calculadoradecalorias.controller;

import com.mercadolibre.calculadoradecalorias.dto.response.PlatoDTO;
import com.mercadolibre.calculadoradecalorias.service.PlatoServiceImp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    PlatoServiceImp platoService;

    public PlatoController (PlatoServiceImp platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/platos/{plato}")
    public ResponseEntity<PlatoDTO> getByName (@PathVariable String plato) {
        PlatoDTO platoBuscado = platoService.getByName(plato);
        return new ResponseEntity<>(platoBuscado, HttpStatus.OK);
    }
}
