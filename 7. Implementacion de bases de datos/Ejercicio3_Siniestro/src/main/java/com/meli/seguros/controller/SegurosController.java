package com.meli.seguros.controller;

import com.meli.seguros.dto.NewSiniestroDto;
import com.meli.seguros.dto.NewVehiculoDto;
import com.meli.seguros.service.ISegurosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/seguros/")
public class SegurosController {
    ISegurosService service;

    public SegurosController(ISegurosService service) {
        this.service = service;
    }

    @PostMapping("/auto/new")
    public ResponseEntity<?> newAuto(@RequestBody NewVehiculoDto v) {
        return ResponseEntity.ok(service.addNewVehiculo(v));
    }

    @PostMapping("/siniestro/new")
    public ResponseEntity<?> newSiniestro(@RequestBody NewSiniestroDto s) {
        return ResponseEntity.ok(service.addNewSiniestro(s));
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> listarPatentes(){
        return  new ResponseEntity<>(service.listarPatentes() , HttpStatus.OK);
    }

    @GetMapping("/siniestros")
    public ResponseEntity<?> listaSiniestros(){
        return new ResponseEntity<>(service.)
    }

}
