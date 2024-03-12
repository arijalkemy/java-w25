package com.bootcamp.ejercicio_vehiculos_siniestros.controller;

import com.bootcamp.ejercicio_vehiculos_siniestros.service.IVehiculoService;
import com.bootcamp.ejercicio_vehiculos_siniestros.service.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    IVehiculoService vehiculoService;
    public VehiculoController(VehiculoServiceImpl vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    //Listar las patentes de todos los vehículos registrados.
    @GetMapping("/patentes")
    public ResponseEntity<?> getPatentes() {
        return new ResponseEntity<>(this.vehiculoService.getPatentes(), HttpStatus.OK);
    }

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @GetMapping("/patentesMarcas")
    public ResponseEntity<?> getPatenteAndMarca() {
        return new ResponseEntity<>(this.vehiculoService.getPatenteAndMarca(), HttpStatus.OK);
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @GetMapping("/patente/more_than_four_wheels_this_year")
    public ResponseEntity<?> getPatentesMoreThanFourWheelsThisYear() {
        return new ResponseEntity<>(this.vehiculoService.getPatentesMoreThanFourWheelsThisYear(), HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un
    // siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/siniestro/more_than_10000")
    public ResponseEntity<?> getSiniestroPerdida() {
        return new ResponseEntity<>(this.vehiculoService.getSiniestroPerdida(), HttpStatus.OK);
    }
    //Listar la matrícula, marca y modelo de todos los vehículos que
    // hayan tenido un siniestro con pérdida mayor de 10000 pesos
    // y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/siniestro/more_than_10000/sum")
    public ResponseEntity<?> getSiniestroPerdidaTotal() {
        return new ResponseEntity<>(this.vehiculoService.getPerdidatotal(), HttpStatus.OK);
    }
}
