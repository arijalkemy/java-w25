package com.consultashql.controller;

import com.consultashql.DTO.VehiculoDTO;
import com.consultashql.DTO.SiniestroDTO;
import com.consultashql.service.ISiniestroService;
import com.consultashql.service.IVehiculoService;
import com.consultashql.service.SiniestroServiceImp;
import com.consultashql.service.VehiculoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SiniestroController {

    private final IVehiculoService vehiculoService;
    private final ISiniestroService siniestroService;

    public SiniestroController(VehiculoServiceImp vehiculoServiceImp, SiniestroServiceImp siniestroServiceImp){

        this.siniestroService = siniestroServiceImp;
        this.vehiculoService = vehiculoServiceImp;
    }

    @PostMapping("/vehiculo")
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoDTO vehiculo){
        return new ResponseEntity<>(vehiculoService.addNewVehiculo(vehiculo), HttpStatus.OK);
    }
    @GetMapping("/vehiculo/patente")
    public ResponseEntity<?> getVehiculo(){
        return new ResponseEntity<>(vehiculoService.getVehiculos(), HttpStatus.OK);
    }
    @GetMapping("/vehiculo/patenteMarca")
    public ResponseEntity<?> getPatenteMarca(){
        return new ResponseEntity<>(vehiculoService.getPatenteMarca(), HttpStatus.OK);
    }
    @GetMapping("/vehiculo/ruedas/anio")
    public ResponseEntity<?> getRuedasAnio(){
        return new ResponseEntity<>(vehiculoService.getRuedasAnio(), HttpStatus.OK);
    }
    @GetMapping("/vehiculo/siniestro")
    public ResponseEntity<?> getVehiculoSiniestro(@RequestParam( defaultValue = "none") String x){
        return new ResponseEntity<>(vehiculoService.getVehiculoSiniestro(x), HttpStatus.OK);
    }
    @PostMapping("/siniestro")
    public ResponseEntity<?> addNewSiniestro(@RequestBody SiniestroDTO siniestroDTO){
        return  new ResponseEntity<>(siniestroService.addNewSiniestro(siniestroDTO), HttpStatus.CREATED);
    }
}
