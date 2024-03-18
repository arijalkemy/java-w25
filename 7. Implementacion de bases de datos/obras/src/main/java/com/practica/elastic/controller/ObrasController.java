package com.practica.elastic.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practica.elastic.dto.ObrasDTO;
import com.practica.elastic.service.IObrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("obras")
public class ObrasController {

    @Autowired
    IObrasService service;

    @PostMapping("/new")
    public ResponseEntity<?> newObra(@RequestBody ObrasDTO obrasDTO){

        return new ResponseEntity<>(service.crearObra(obrasDTO), HttpStatus.CREATED);
    }

    @GetMapping("/year")
    public ResponseEntity<?> findByPublicacion(){

        return new ResponseEntity<>(service.findByDate(LocalDate.of(1890, 1, 1)), HttpStatus.CREATED);
    }

    @GetMapping("/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor){

        return new ResponseEntity<>(service.findByAutor(autor), HttpStatus.CREATED);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial){

        return new ResponseEntity<>(service.findByEditorial(editorial), HttpStatus.CREATED);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){

        return new ResponseEntity<>(service.findByName(name), HttpStatus.CREATED);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTop(){

        return new ResponseEntity<>(service.findByPage(), HttpStatus.CREATED);
    }
}
