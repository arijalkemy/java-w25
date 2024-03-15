package com.bootcamp.elasticSearch.controller;

import com.bootcamp.elasticSearch.dto.ObraLiterariaDto;
import com.bootcamp.elasticSearch.service.IObraLiterariaService;
import com.bootcamp.elasticSearch.service.ObraLiterariaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraLiterariaController {

    IObraLiterariaService service;

    public ObraLiterariaController(ObraLiterariaServiceImpl obraLiterariaService) {
        this.service = obraLiterariaService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveObra(@RequestBody ObraLiterariaDto obraLiterariaDto) {
        return new ResponseEntity<>(service.saveObra(obraLiterariaDto), HttpStatus.OK);
    }

    //Retornar todas las obras por autor
    @GetMapping("/buscarporautor/{autor}")
    public  ResponseEntity<List<ObraLiterariaDto>> getObra(@PathVariable String autor){
        return new ResponseEntity<>(service.getObrasByAutor(autor), HttpStatus.OK);
    }

    //Retornar las obras que contengan palabras claves en sus títulos
    @GetMapping("/buscarportitulo/{titulo}")
    public  ResponseEntity<List<ObraLiterariaDto>> getObrasByTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(service.getObrasByTitulo(titulo), HttpStatus.OK);
    }


    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top5")
    public  ResponseEntity<List<ObraLiterariaDto>> getObra(){
        return new ResponseEntity<>(service.getObrasTop5QuantityPages(), HttpStatus.OK);
    }

    //Retornar las obras que fueron publicadas antes de un determinado año
    @GetMapping("/buscarporanio/{anio}")
    public  ResponseEntity<List<ObraLiterariaDto>> getObrasByAnio(@PathVariable int anio){
        return new ResponseEntity<>(service.getObrasBefore(anio), HttpStatus.OK);
    }

    //Retornar todas las obras de una determinada editorial
    @GetMapping("/buscarporeditorial/{editorial}")
    public  ResponseEntity<List<ObraLiterariaDto>> getObrasByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(service.getObrasByEditorial(editorial), HttpStatus.OK);
    }
}
