package com.example.hqlsegurosvehiculos.controller;


import com.example.hqlsegurosvehiculos.dto.response.VehiculoDTO;
import com.example.hqlsegurosvehiculos.dto.response.request.NuevoVehiculoDTO;
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
    public ResponseEntity<VehiculoDTO> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping("/findAll_patentes")
    public ResponseEntity<List<String>> getAllPatentes(){
        List<String> lPatentes = service.findAllPatentes();
        return ResponseEntity.ok(lPatentes);
    }

    @PostMapping("/addVehicles/")
    public ResponseEntity<NuevoVehiculoDTO> create(@RequestBody NuevoVehiculoDTO vehiculo){
        return new ResponseEntity<>(service.create(vehiculo), HttpStatus.CREATED);
    }
}
