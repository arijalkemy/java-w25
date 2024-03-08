package com.example.jpa.controller;

import com.example.jpa.model.Miniserie;
import com.example.jpa.service.MiniserieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniserieController {

    MiniserieService miniserieService;
    public MiniserieController(MiniserieService miniserieService) {
        this.miniserieService = miniserieService;
    }

    @PostMapping("/create")
    public ResponseEntity<Miniserie> createNewMiniserie(@RequestBody Miniserie miniserie){
        return new ResponseEntity<>(miniserieService.crearMiniSerie(miniserie), HttpStatus.OK);
    }

}
