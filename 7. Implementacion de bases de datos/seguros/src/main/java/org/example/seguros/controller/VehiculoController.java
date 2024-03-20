package org.example.seguros.controller;

import org.apache.coyote.Response;
import org.example.seguros.dto.request.VehiculoReqDTO;
import org.example.seguros.dto.response.VehiculoPatYMarcaRespDTO;
import org.example.seguros.dto.response.VehiculoRespDTO;
import org.example.seguros.service.IVehiculoService;
import org.example.seguros.service.impl.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class VehiculoController {
    private final IVehiculoService vehiculoService;
    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/vehicle")
    public ResponseEntity<VehiculoRespDTO> createVehicle(VehiculoReqDTO vehiculoReqDTO) {
        return new ResponseEntity<>(vehiculoService.crearVehiculo(vehiculoReqDTO), HttpStatus.CREATED);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getAllPatentes(){
        return new ResponseEntity<>(vehiculoService.findAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentemarcaorderbyanio")
    public ResponseEntity<List<VehiculoPatYMarcaRespDTO>> getPatentesAndMarcaOrderByAnio(){
        return new ResponseEntity<>(vehiculoService.findAllPatentesAndMarcaOrderByAnioFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patentesmasdecuatroruedas")
    public ResponseEntity<List<String>> getPatentesVehiculosMasCuatroRuedasByAnioActual(){
        return new ResponseEntity<>(vehiculoService.findPatentesVehiculosMasCuatroRuedasByAnioActual(), HttpStatus.OK);
    }
}
