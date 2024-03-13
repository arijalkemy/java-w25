package com.example.ObrasLiterarias.controller;

import com.example.ObrasLiterarias.dto.ObraLiterariaDTO;
import com.example.ObrasLiterarias.service.IObraLiterariaService;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;
import java.lang.annotation.Retention;
import java.util.List;

@RestController
@RequestMapping("/obra-literaria")
public class ObraLiterariaController {

    IObraLiterariaService iObraLiterariaService;

    public ObraLiterariaController (IObraLiterariaService iObraLiterariaService){
        this.iObraLiterariaService = iObraLiterariaService;
    }



    //Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    @GetMapping("/author/{name}")
    public ResponseEntity<?> getObrasLiterarias(@PathVariable("name") String name){
        return new ResponseEntity<>(iObraLiterariaService.getObrasLiterariasDeAutor(name), HttpStatus.OK);
    }



    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @GetMapping("/title/{keyword}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraLiterariaByTitle(@PathVariable("keyword") String keyword){
        return ResponseEntity.ok().body(iObraLiterariaService.getObraLiterariaByTitle(keyword));
    }


    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top5")
    public ResponseEntity<?> getTopFiveMorePages(){
        return new ResponseEntity<>(iObraLiterariaService.getTopFiveMorePages(), HttpStatus.OK);
    }


    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @GetMapping("/title/before/{year}")
    public ResponseEntity<?> getTitlesBeforeYear(@PathVariable("year") Integer year){
        return new ResponseEntity<>(iObraLiterariaService.getTitlesBeforeYear(year), HttpStatus.OK);
    }


    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    @GetMapping("/title/editorial/{name}")
    public ResponseEntity<?> getTitlesByEditorial(@PathVariable("name") String name){
        return new ResponseEntity<>(iObraLiterariaService.getTitlesByEditorial(name), HttpStatus.OK);
    }

    //Crear una obra literaria
    @PostMapping("/")
    public ResponseEntity<?> createLiteraryWork(@RequestBody ObraLiterariaDTO obra) {
        return new ResponseEntity<>(iObraLiterariaService.saveLiteraryWork(obra), HttpStatus.OK);
    }


}
