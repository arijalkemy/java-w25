package com.bootcamp.ejercicio_consultas_HQL.controller;

import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqVehiculoDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.*;
import com.bootcamp.ejercicio_consultas_HQL.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createVehiculo(@RequestBody ReqVehiculoDTO vehicleDTO) {
        return ResponseEntity.ok((vehiculoService.createVehiculo(vehicleDTO)));
    }
    @GetMapping()
    public ResponseEntity<List<ResVehiculoDTO>> getAllVehiculos() {
        return ResponseEntity.ok(vehiculoService.getAllVehiculos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResVehiculoDTO> getVehiculoById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getById(id));
    }
    @GetMapping("/patente")
    public ResponseEntity<List<PatenteDTO>> getAllPatentes() {
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }
    @GetMapping("/patente/marca")
    public ResponseEntity<List<PatenteYMarcaDTO>> getAllPatenteYMarcaOrdenados() {
        return ResponseEntity.ok(vehiculoService.getAllPatenteYMarcaOrdenados());
    }
    @GetMapping("/patente/ruedas/thisYear")
    public ResponseEntity<List<PatenteDTO>> getAllPatenteThisYear() {
        return ResponseEntity.ok(vehiculoService.getAllPatenteThisYear());
    }
    @GetMapping("/patente/marca/modelo")
    public ResponseEntity<List<PatenteMarcaModeloDTO>> getAllPatenteMarcaModelo() {
        return ResponseEntity.ok(vehiculoService.getAllPatenteMarcaModelo());
    }
    @GetMapping("/patente/marca/modelo/perdidaTotal")
    public ResponseEntity<List<PatenteMarcaModeloPerdidaTotalDTO>> getAllPatenteMarcaModeloPerdidaTotal() {
        return ResponseEntity.ok(vehiculoService.getAllPatenteMarcaModeloPerdidaTotal());
    }
}
