package com.implementacionbd.ejercicio.controllers;

import com.implementacionbd.ejercicio.models.Siniestro;
import com.implementacionbd.ejercicio.models.Vehiculo;
import com.implementacionbd.ejercicio.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping("/api/vehiculos/new")
    public ResponseEntity<?> saveNewVehiculo(@RequestBody Vehiculo vehiculoNuevo) {
        return new ResponseEntity<>(vehiculoService.saveVehiculo(vehiculoNuevo), HttpStatus.OK);
    }

    @GetMapping("/api/vehiculos")
    public ResponseEntity<?> getVehiculos() {
        return new ResponseEntity<>(vehiculoService.getAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/api/siniestros/{id_vehiculo}")
    public ResponseEntity<?> getSingleVehiculo(@PathVariable long id_vehiculo){
        return new ResponseEntity<>(vehiculoService.getSiniestrosByIdVehiculo(id_vehiculo), HttpStatus.OK);
    }

    @PostMapping("/api/siniestros/{id_vehiculo}/new")
    public ResponseEntity<?> saveSiniestro(@PathVariable Long id_vehiculo, @RequestBody Siniestro nuevoSiniestro) {
        return new ResponseEntity<>(vehiculoService.saveSiniestroByVehiculoId(id_vehiculo, nuevoSiniestro),HttpStatus.OK);
    }

    /*Endpoints para Consultas HQL*/
    @GetMapping("/api/vehiculos/patentes")
    public ResponseEntity<?> getAllPatentes(){
        return new ResponseEntity<>(vehiculoService.getPatentes(), HttpStatus.OK);
    }

    @GetMapping("/api/vehiculos/patentesYmarca/yearOrder")
    public ResponseEntity<?> getSingleCase(){
        return new ResponseEntity<>(vehiculoService.getPatentesAndMarcasOrderByYear(), HttpStatus.OK);
    }



    @GetMapping("/api/vehiculos/getall")
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<>()
    }

}
