package com.bootcamp.hql.controller;

import com.bootcamp.hql.model.dto.CreateSiniestroDto;
import com.bootcamp.hql.model.dto.CreateVehiculoDto;
import com.bootcamp.hql.model.dto.LinkSiniestroDto;
import com.bootcamp.hql.service.VehiculoService;
import com.bootcamp.hql.service.interfaces.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SegurosController {
    private IVehiculoService vehiculoService;

    public SegurosController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> listarPatentes(){
        return new ResponseEntity<>(vehiculoService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentesYMarcas")
    public ResponseEntity<?> listarPatentesYMarcas(){
        return new ResponseEntity<>(vehiculoService.getAllPatentesAndMarcaByAnnoFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patentes4Ruedas")
    public ResponseEntity<?> listarPatentesMas4Ruedas(){
        return new ResponseEntity<>(vehiculoService.getPatenteByRuedasAndAnnoFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patenteSiniestroMayorA10000")
    public ResponseEntity<?> listarPatentesSiniestroMayorA10000(){
        return new ResponseEntity<>(vehiculoService.getMatriculaAndMarcaAndModeloByPerdidaEconomica(), HttpStatus.OK);
    }

    @GetMapping("/patentesSiniestroMayorA10000ConPerdidaTotal")
    public ResponseEntity<?> listarPatentesSiniestroMayorA10000ConPerdidaTotal(){
        return new ResponseEntity<>(vehiculoService.getMatriculaAndMarcaAndModeloAndPerdidaTotalByPerdidaEconomica(), HttpStatus.OK);
    }

    @PostMapping("/createVehiculos")
    public ResponseEntity<?> createVehiculos(
        @RequestBody List<CreateVehiculoDto> vehiculosACrear
    ){
        return new ResponseEntity<>(vehiculoService.createVehiculos(vehiculosACrear), HttpStatus.OK);
    }

    @PostMapping("/createSiniestros")
    public ResponseEntity<?> createSiniestros(
        @RequestBody List<CreateSiniestroDto> siniestrosACrear
    ){
        return new ResponseEntity<>(vehiculoService.createSiniestros(siniestrosACrear), HttpStatus.OK);
    }

    @PostMapping("/asociarSiniestroAVehiculo")
    public ResponseEntity<?> asociarSiniestroAVehiculo(
            @RequestBody LinkSiniestroDto linkSiniestroDto
            ){
        return new ResponseEntity<>(vehiculoService.asociarSiniestroAVehiculo(linkSiniestroDto), HttpStatus.OK);
    }
}