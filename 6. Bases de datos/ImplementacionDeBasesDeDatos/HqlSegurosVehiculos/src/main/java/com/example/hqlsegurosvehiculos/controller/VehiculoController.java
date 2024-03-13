package com.example.hqlsegurosvehiculos.controller;


import com.example.hqlsegurosvehiculos.dto.response.PatenteAndYearDTO;
import com.example.hqlsegurosvehiculos.dto.response.PatentesDTO;
import com.example.hqlsegurosvehiculos.dto.response.SiniestrosDTO;
import com.example.hqlsegurosvehiculos.dto.response.VehiculoDTO;
import com.example.hqlsegurosvehiculos.dto.request.NuevoVehiculoDTO;
import com.example.hqlsegurosvehiculos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehiculoController {

    @Autowired
    IVehiculoService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<VehiculoDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findSiniestros")
    public ResponseEntity<List<SiniestrosDTO>> showAllSiniestro(){
        return new ResponseEntity<>(service.findAllSiniestros(), HttpStatus.OK);
    }

    @PostMapping("/addVehicles/")
    public ResponseEntity<NuevoVehiculoDTO> create(@RequestBody NuevoVehiculoDTO vehiculo){
        return new ResponseEntity<>(service.create(vehiculo), HttpStatus.CREATED);
    }


    @GetMapping("/findAllpatentes")
    public ResponseEntity<List<PatentesDTO>> getAllPatentes(){
        return new ResponseEntity<>(service.findAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/findAllOrderbyYearFab")
    public ResponseEntity<List<PatenteAndYearDTO>> getAllPatentesOrderbyYearFab(){
        return new ResponseEntity<>(service.getAllPatentesOrderbyYearFab(), HttpStatus.OK);
    }

    @GetMapping("/vehiclesMoreThan4Wheels")
    public ResponseEntity<List<PatenteAndYearDTO>> getAllVehiclesMoreThan4Wheels(){
        return new ResponseEntity<>(service.getAllVehiclesMoreThan4Wheels(), HttpStatus.OK);
    }
}
