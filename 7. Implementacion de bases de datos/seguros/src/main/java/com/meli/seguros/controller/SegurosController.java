package com.meli.seguros.controller;

import com.meli.seguros.dto.response.*;
import com.meli.seguros.dto.request.NewSiniestroDto;
import com.meli.seguros.dto.request.NewVehiculoDto;
import com.meli.seguros.service.ISegurosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/seguros/")
public class SegurosController {
    ISegurosService service;

    public SegurosController(ISegurosService service) {
        this.service = service;
    }

    @PostMapping("/auto/new")
    public ResponseEntity<?> newAuto(@RequestBody NewVehiculoDto v) {
        return ResponseEntity.ok(service.addNewVehiculo(v));
    }

    @PostMapping("/siniestro/new")
    public ResponseEntity<?> newSiniestro(@RequestBody NewSiniestroDto s) {
        return ResponseEntity.ok(service.addNewSiniestro(s));
    }

    @GetMapping("/siniestro")
    public ResponseEntity<List<ResSiniestroDto>> listarSiniestros(){
        return new ResponseEntity<>(service.getAllSiniestros(), HttpStatus.OK);
    }

    @GetMapping("/auto")
    public ResponseEntity<?> listarVehiculos(){
        return new ResponseEntity<>(service.getAllVehiculos(), HttpStatus.OK);
    }

    //Listar las patentes de todos los vehículos registrados.
    @GetMapping("/patentes")
    public ResponseEntity<?> listarPatentes(){
        return new ResponseEntity<>(service.listarPatentes() , HttpStatus.OK);
    }

    //listarAllPatenteYMarcaSortByAnioFabricacion
    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @GetMapping("/auto/patente-marca/fabrication_year")
    public ResponseEntity<List<PatenteMarcaDto>> listarPatenteYMarcaOrderByAnioDeFabricacion(){
        return new ResponseEntity<>(service.listarAllPatenteYMarcaSortByAnioFabricacion() , HttpStatus.OK);
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @GetMapping("/auto/patente-4wheels_or_more-current_year/")
    public ResponseEntity<List<PatenteDto>> listarPatentesBy4WheelsOrMoreAndFabricatedWithinCurrentYear(){
        return new ResponseEntity<>(service.listarPatentesBy4WheelsOrMoreAndFabricatedWithinCurrentYear() , HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos
    // que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/auto/siniestro/10000")
    public ResponseEntity<List<PatenteMarcaModeloDto>> listarByPerdidaSiniestroMayorA10000(){
        return new ResponseEntity<>(service.listarByPerdidaSiniestroMayorA10000() , HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    // con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/auto/siniestro/total_loss/10000")
    public ResponseEntity<VehiculoSiniestroDTO> listarByPerdidaSiniestroMayorA10000ShowTotalLoss(){
        return new ResponseEntity<>(service.listarByPerdidaSiniestroMayorA10000ShowTotalLoss() , HttpStatus.OK);
    }
}
