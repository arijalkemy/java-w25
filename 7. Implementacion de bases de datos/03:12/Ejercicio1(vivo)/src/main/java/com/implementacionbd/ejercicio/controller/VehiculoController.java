package com.implementacionbd.ejercicio.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementacionbd.ejercicio.dto.MessageResDTO;
import com.implementacionbd.ejercicio.dto.VehiculoReqDTO;
import com.implementacionbd.ejercicio.service.IVehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // 1.- Listar las patentes de todos los vehículos registrados.
    @GetMapping
    public ResponseEntity<?> getPatentesRegistradas() {
        return ResponseEntity.ok().body(vehiculoService.getPatentesRegistradas());
    }

    // 2.- Listar la patente y la marca de todos los vehículos ordenados por año de
    // fabricación.
    @GetMapping("/patente-marca")
    public ResponseEntity<?> getPatentesYMarcaPorAnio() {
        return ResponseEntity.ok().body(vehiculoService.getPatentesYMarcaPorAnio());
    }

    // 3.- Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @GetMapping("/ruedas")
    public ResponseEntity<?> getCuatriRuedasYAnioCorriente() {
        return ResponseEntity.ok().body(vehiculoService.getCuatriRuedasYAnioCorriente());
    }

    // 4.- Listar la matrícula, marca y modelo de todos los vehículos que hayan
    // tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/perdida-mayor-10000")
    public ResponseEntity<?> getMatriculaMarcaModeloPerdidaMayorA() {
        return ResponseEntity.ok().body(vehiculoService.getMatriculaMarcaModeloPerdidaMayorA(10000));
    }

    // AUX.- Crear vehiculo:
    @PostMapping("/new")
    public ResponseEntity<MessageResDTO> postTestCase(@RequestBody VehiculoReqDTO vehiculoReqDTO) {
        MessageResDTO messageRes = vehiculoService.postVehiculo(vehiculoReqDTO);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(201));
    }
}