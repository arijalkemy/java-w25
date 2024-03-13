package com.example.elasticDemo.controller;

import com.example.elasticDemo.dto.ClothesDTO;
import com.example.elasticDemo.services.ClothesServiceImpl;
import com.example.elasticDemo.services.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    private IClothesService service;

    public ClothesController(ClothesServiceImpl clothesService){
        this.service = clothesService;
    }

    @PostMapping("")
    public ResponseEntity<?> agregarPrenda(@RequestBody ClothesDTO prendaDto){
        return new ResponseEntity<>(service.create(prendaDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> obtenerPrendas(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> obtenerPrendaPorTalle(@PathVariable Double size){
        return new ResponseEntity<>(service.findAllByTalle(size), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> obtenerPrendaPorCodigo(@PathVariable Long code){
        return new ResponseEntity<>(service.findById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}") // CORREGIR
    public ResponseEntity<?> actualizarPrendaPorCodigo( @PathVariable Long code,
                                                        @RequestBody ClothesDTO prendaDto){
        return new ResponseEntity<>(service.update(prendaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> eliminarPrendaPorCodigo(@PathVariable Long code){
        return new ResponseEntity<>(service.delete(code), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> obtenerPrendasByName(@RequestParam String name){
        return new ResponseEntity<>(service.findAllByNameRegex(name), HttpStatus.OK);
    }
}
