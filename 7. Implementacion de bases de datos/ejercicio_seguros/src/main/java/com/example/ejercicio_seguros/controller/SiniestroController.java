package com.example.ejercicio_seguros.controller;

import com.example.ejercicio_seguros.dto.MensajeDTO;
import com.example.ejercicio_seguros.dto.SiniestroDTO;
import com.example.ejercicio_seguros.dto.VehiculoDTO;
import com.example.ejercicio_seguros.service.ISiniestroService;
import com.example.ejercicio_seguros.service.IVehiculoService;
import com.example.ejercicio_seguros.service.SiniestroServiceImpl;
import com.example.ejercicio_seguros.service.VehiculoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {
    private final ISiniestroService siniestroService;

    public SiniestroController(SiniestroServiceImpl siniestroService){
        this.siniestroService = siniestroService;
    }

    @GetMapping("")
    public ResponseEntity<List<SiniestroDTO>> listSiniestros(){
        return ResponseEntity.ok().body(this.siniestroService.listSiniestros());
    }

    @PostMapping("")
    public ResponseEntity<MensajeDTO> saveSiniestro(@RequestBody SiniestroDTO siniestroDTO){
        return ResponseEntity.ok().body(this.siniestroService.guardarSinisetro(siniestroDTO));
    }
}
