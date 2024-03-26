package com.example.SegurosDeAutos.controller;

import com.example.SegurosDeAutos.dto.RequestSiniestroDTO;
import com.example.SegurosDeAutos.service.ISiniestroServices;
import com.example.SegurosDeAutos.service.IVehiculoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {
    private final ISiniestroServices siniestroService;
    public SiniestroController(ISiniestroServices siniestroService){
        this.siniestroService=siniestroService;
    }

    @PostMapping("")
    public ResponseEntity<?> guardarSiniestro(@RequestBody RequestSiniestroDTO nuevoSiniestro){
        return ResponseEntity.ok(siniestroService.addSiniestro(nuevoSiniestro));
    }

    @GetMapping("")
    public ResponseEntity<?> consultarSiniestros(){
        return ResponseEntity.ok(siniestroService.getSiniestros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarSiniestroById(@PathVariable Long id){
        return ResponseEntity.ok(siniestroService.getSiniestroById(id));
    }

}
