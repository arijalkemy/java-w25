package com.example.CalculadoraDeCalorias.controller;

import com.example.CalculadoraDeCalorias.dto.response.CalculadoraDTO;
import com.example.CalculadoraDeCalorias.service.IPlatoService;
import com.example.CalculadoraDeCalorias.service.PlatoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    private IPlatoService platoService;

    public PlatoController(PlatoServiceImp platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/calcular/{plato}")
    public ResponseEntity<CalculadoraDTO> calcular(@PathVariable String plato, @RequestParam int peso) {
        return new ResponseEntity<>(platoService.calcular(plato, peso), HttpStatus.OK);
    }

}
