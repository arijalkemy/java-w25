package com.dto.deportistas.controller;

import com.dto.deportistas.model.Deporte;
import com.dto.deportistas.service.ServiceDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    ServiceDeporte serviceDeporte;


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeportes(){
        System.out.println();
        System.out.println("http://localhost:8080/");
        return new ResponseEntity<>(serviceDeporte.getDeportes(), HttpStatus.OK);
    }
    @GetMapping("/findSports/{name}")
    public ResponseEntity<List<Deporte>> getDeportes(@PathVariable String name){
        return new ResponseEntity<>(serviceDeporte.findByName(name), HttpStatus.OK);
    }
}
