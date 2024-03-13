package com.bootcamp.hql.controller;

import com.bootcamp.hql.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeguroController {

    private final IVehiculoService vehiculoService;

    public SeguroController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    //Listar las patentes de todos los vehículos registrados.
    @GetMapping("/patentes")
    public ResponseEntity<?> listarPatentes() {
        return new ResponseEntity<>(vehiculoService.ObtenerPatentesVehiculosRegistrados(), HttpStatus.OK);
    }

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @GetMapping("/patentesYMarcas")
    public ResponseEntity<?> listarPatentesYMarcas() {
        return new ResponseEntity<>(vehiculoService.ObtenerPatentesYMarcaPorAnio(), HttpStatus.OK);
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @GetMapping("/patentes4Ruedas")
    public ResponseEntity<?> listarPatentesMas4Ruedas() {
        return new ResponseEntity<>(vehiculoService.ObtenerPatentesVehiculosMasDe4RuedasAnioActual(), HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/patenteSiniestroMayorA10000")
    public ResponseEntity<?> listarPatentesSiniestroMayorA10000() {
        return new ResponseEntity<>(vehiculoService.ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000(), HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/patentesSiniestroMayorA10000ConPerdidaTotal")
    public ResponseEntity<?> listarPatentesSiniestroMayorA10000ConPerdidaTotal(){
        return new ResponseEntity<>(vehiculoService.ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000ConPerdidaTotal(), HttpStatus.OK);
    }




}
