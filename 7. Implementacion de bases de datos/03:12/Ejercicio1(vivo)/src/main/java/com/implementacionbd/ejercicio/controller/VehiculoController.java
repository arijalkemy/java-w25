package com.implementacionbd.ejercicio.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementacionbd.ejercicio.dto.MessageResDTO;
import com.implementacionbd.ejercicio.dto.SiniestroReqDTO;
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
    /*
     * {
     * "patente": "AB123CD",
     * "marca": "Fiat",
     * "anyo_fabricacion": "2020-12-30",
     * "cantidad_ruedas": 4,
     * "modelo": "Palio"
     * }
     */
    @PostMapping("/new-vehiculo")
    public ResponseEntity<MessageResDTO> postTestCase(@RequestBody VehiculoReqDTO vehiculoReqDTO) {
        MessageResDTO messageRes = vehiculoService.postVehiculo(vehiculoReqDTO);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(201));
    }

    // AUX.- Crear siniestro:
    /*
     * {
     * "fecha_siniestro": "2023-10-30",
     * "perdida_economica": 40000.00
     * }
     */
    @PostMapping("/new-siniestro/{vehiculoId}")
    public ResponseEntity<MessageResDTO> postTestCase(@PathVariable Long vehiculoId,
            @RequestBody SiniestroReqDTO siniestroReqDTO) {
        MessageResDTO messageRes = vehiculoService.postSiniestro(vehiculoId, siniestroReqDTO);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(201));
    }
}