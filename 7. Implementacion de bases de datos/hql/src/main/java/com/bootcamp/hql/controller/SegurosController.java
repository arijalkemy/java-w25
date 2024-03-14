package com.bootcamp.hql.controller;

import com.bootcamp.hql.service.SiniestroService;
import com.bootcamp.hql.service.VehiculoService;
import com.bootcamp.hql.service.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegurosController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<?> listarPatentes(){
        return new ResponseEntity<>(vehiculoService.ObtenerPatentesVehiculosRegistrados(), HttpStatus.OK);
    }

    @GetMapping("/patentesYMarcas")
    public ResponseEntity<?> listarPatentesYMarcas(){
        return new ResponseEntity<>(vehiculoService.ObtenerPatentesYMarcaPorAnno(), HttpStatus.OK);
    }

    @GetMapping("/patentes4Ruedas")
    public ResponseEntity<?> listarPatentesMas4Ruedas(){
        return new ResponseEntity<>(vehiculoService.ObtenerPatentesVehiculosMasDe4RuedasAnnoActual(), HttpStatus.OK);
    }

    @GetMapping("/patenteSiniestroMayorA10000")
    public ResponseEntity<?> listarPatentesSiniestroMayorA10000(){
        return new ResponseEntity<>(vehiculoService.ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000(), HttpStatus.OK);
    }

    @GetMapping("/patentesSiniestroMayorA10000ConPerdidaTotal")
    public ResponseEntity<?> listarPatentesSiniestroMayorA10000ConPerdidaTotal(){
        return new ResponseEntity<>(vehiculoService.ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000ConPerdidaTotal(), HttpStatus.OK);
    }
    @GetMapping("/perdidaTotalSiniestroMayorA10000")
    public ResponseEntity<?> obtenerPerdidaTotalSiniestroMayorA10000(){
        return new ResponseEntity<>(vehiculoService.ObtenerPerdidaTotalSiniestrosMayorA10000(), HttpStatus.OK);
    }




}
