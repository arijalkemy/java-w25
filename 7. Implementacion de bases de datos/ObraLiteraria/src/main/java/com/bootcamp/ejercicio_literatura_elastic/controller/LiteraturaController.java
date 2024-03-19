package com.bootcamp.ejercicio_literatura_elastic.controller;

import com.bootcamp.ejercicio_literatura_elastic.dto.ObraLiterariaDTO;
import com.bootcamp.ejercicio_literatura_elastic.service.IObrasService;
import com.bootcamp.ejercicio_literatura_elastic.service.ObrasServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class LiteraturaController {
    private final IObrasService obrasService;

    public LiteraturaController(ObrasServiceImpl obrasService) {
        this.obrasService = obrasService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createObra(@RequestBody ObraLiterariaDTO obra) {
        return new ResponseEntity<>(this.obrasService.saveObra(obra), HttpStatus.OK);
    }

    //Retornar las obras de un determinado autor
    // . Por ejemplo, todas las obras de “Garcia Marquez”
    @GetMapping("/autor")
    public ResponseEntity<?> getObrasByAutor(@RequestParam String nombre_autor){
        return new ResponseEntity<>(this.obrasService.getByAutor(nombre_autor), HttpStatus.OK);
    }

    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> findTitleObra(@PathVariable String titulo) {
        return new ResponseEntity<>(this.obrasService.findTitleObra(titulo), HttpStatus.OK);
    }


    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top/paginas")
    public ResponseEntity<?> obrasConMasPaginas(){
        return new ResponseEntity<>(obrasService.obtenerObrasConMasPaginas(), HttpStatus.OK);
    }

    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @GetMapping("/{anio}")
    public ResponseEntity<?> getObrasAntesDelAnio(@PathVariable int anio){
        return new ResponseEntity<>(obrasService.getObrasAntesDelAnio(anio), HttpStatus.OK);
    }

    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> editorialObra(@PathVariable String editorial){
        return new ResponseEntity<>(this.obrasService.getByEditorial(editorial), HttpStatus.OK);
    }
}
