package com.example.ElasticDemo01.controller;

import com.example.ElasticDemo01.dto.ObraDto;
import com.example.ElasticDemo01.service.ObraServiceImpl;
import com.example.ElasticDemo01.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/obras")
public class ObraController {

    private final IObraService obraService;
    public ObraController(ObraServiceImpl service){
        this.obraService =service;
    }

    @PostMapping("")
    public ResponseEntity<?> saveObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(obraService.saveObra(obraDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(obraService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create-list")
    public ResponseEntity<?> saveMultipleObras(@RequestBody List<ObraDto> obras){
        return new ResponseEntity<>(obraService.saveObras(obras),HttpStatus.OK);
    }

    //Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getObrasByAutor(@PathVariable String autor){
        return new ResponseEntity<>(obraService.getByAutor(autor),HttpStatus.OK);
    }

    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> getObrasByTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(obraService.getByTitulo(titulo),HttpStatus.OK);
    }

    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/pages")
    public ResponseEntity<?> getObrasOrderByPageDesc(){
        return new ResponseEntity<>(obraService.getOrderByPageDesc(),HttpStatus.OK);
    }

    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @GetMapping("/anio/{anio}")
    public ResponseEntity<?> getObrasBeforeYear(@PathVariable String anio){
        return new ResponseEntity<>(obraService.getBeforeYear(anio),HttpStatus.OK);
    }

    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getObrasByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(obraService.getByEditorial(editorial),HttpStatus.OK);
    }

}
