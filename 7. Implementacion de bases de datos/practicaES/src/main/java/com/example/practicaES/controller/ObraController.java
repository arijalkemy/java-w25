package com.example.practicaES.controller;

import com.example.practicaES.dto.ObraDto;
import com.example.practicaES.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class ObraController {
    private final IObraService obraService;

    public ObraController(IObraService obraService){
        this.obraService = obraService;
    }

    @PostMapping("")
    public ResponseEntity<?> addObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(obraService.addObra(obraDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllObras(){
        return ResponseEntity.ok(obraService.findAll());
    }

    // Retornar las obras de un determinado autor.
    @GetMapping("/autor/{nombre}")
    public ResponseEntity<?> findByAutor(@PathVariable String nombre){
        return ResponseEntity.ok(obraService.findByAutor(nombre));
    }

    // Retornar las obras que contengan palabras claves en sus títulos.
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombre){
        return ResponseEntity.ok(obraService.findByNombre(nombre));
    }

    // Retornar el top 5 de las obras literarias con más cantidad de páginas.
    @GetMapping("/top_pages")
    public ResponseEntity<?> getTop5Pages(){
        return ResponseEntity.ok(obraService.getTop5Pages());
    }

    // Retornar las obras que fueron publicadas antes de un determinado año.
    @GetMapping("/anio/{year}")
    public ResponseEntity<?> findByYearBefore(@PathVariable Integer year){
        return ResponseEntity.ok(obraService.findByYearBefore(year));
    }

    // Retornar todas las obras de una determinada editorial.
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(obraService.findByEditorial(editorial));
    }

}
