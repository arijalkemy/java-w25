package com.obrasliterarias.elasticsearch.controller;

import com.obrasliterarias.elasticsearch.dto.ObraLiterariaDto;
import com.obrasliterarias.elasticsearch.service.IObraLiterariaService;
import org.springframework.data.domain.Limit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {
    IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(IObraLiterariaService obraLiterariaService){
        this.obraLiterariaService=obraLiterariaService;
    }

    // Create obra literaria
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ObraLiterariaDto obraLiterariaDto){
        return new ResponseEntity<>(obraLiterariaService.save(obraLiterariaDto), HttpStatus.OK);
    }

    // Get all obras
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(obraLiterariaService.getAll(), HttpStatus.OK);
    }

    // Get all obras by Autor
    @GetMapping("/authors/{autor}")
    public ResponseEntity<?> getByAutor(@PathVariable String autor){
        return new ResponseEntity<>(obraLiterariaService.findAllByAutor(autor), HttpStatus.OK);
    }

    // Get all obras by contains name
    @GetMapping("/title")
    public ResponseEntity<?> getByTitleContains(@RequestParam("nombre") String nombre){
        return new ResponseEntity<>(obraLiterariaService.findAllByTitleContains(nombre), HttpStatus.OK);
    }

    @GetMapping("/anio")
    public ResponseEntity<?> getByAnioBefore(@RequestParam("anio") Integer anio){
        return new ResponseEntity<>(obraLiterariaService.findAllByAnioBefore(anio), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(obraLiterariaService.findAllByEditorial(editorial), HttpStatus.OK);
    }

    @GetMapping("/paginas")
    public ResponseEntity<?> getByNumPaginas(){
        return new ResponseEntity<>(obraLiterariaService.findAllByNumPaginasTop5(), HttpStatus.OK);
    }
}
