package com.example.calculadoraCalorias.controller;

import com.example.calculadoraCalorias.dto.PlatoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {

    @GetMapping("/{nombrePlato}/{pesoEnGramo}")
    public List<> caracteristicasPlato(@PathVariable String nombrePlato, @PathVariable int pesoEnGramo){
        return null;
    }
}
