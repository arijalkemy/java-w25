package com.example.demo.controller;

import com.example.demo.dto.PerdidaMayorADto;
import com.example.demo.dto.VehiculoSiniestroDto;
import com.example.demo.service.IVehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@AllArgsConstructor
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<?> getPatentesRegistradas(){
        return ResponseEntity.ok().body(vehiculoService.getPatentesRegistradas());
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<?> getPatentesYMarcaPorAnio() {
        return ResponseEntity.ok().body(vehiculoService.getPatentesYMarcaPorAnio());
    }

    @GetMapping("/ruedas-anio")
    public ResponseEntity<?> getCuatriRuedasYAnioCorriente() {
        return ResponseEntity.ok().body(vehiculoService.getCuatriRuedasYAnioCorriente());
    }

    @GetMapping("/perdida-mayor-a-10000")
    public ResponseEntity<PerdidaMayorADto> getPerdidaMayorA10000(){
        return ResponseEntity.ok().body(vehiculoService.getMatriculaMarcaModeloPerdidaMayorA(10000));
    }

    @GetMapping("/suma-perdida-mayor-a-10000")
    public ResponseEntity<List<VehiculoSiniestroDto>> getSumaPerdidaMayorA10000() {
        return ResponseEntity.ok().body(vehiculoService.getSumaMatriculaMarcaModeloPerdidaMayorA(10000));
    }
}
