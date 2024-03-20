package com.example.ObrasLiterarias.controller;

import com.example.ObrasLiterarias.dto.ObraLiterariaDto;
import com.example.ObrasLiterarias.service.IObraLiterariaService;
import com.example.ObrasLiterarias.service.ObraLiterariaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ObraLiterariaController {

    private IObraLiterariaService service;

    public ObraLiterariaController(ObraLiterariaServiceImpl service){
        this.service = service;
    }

    //OK
    @PostMapping("/new")
    public ResponseEntity<ObraLiterariaDto> saveObraLiteraria(@RequestBody ObraLiterariaDto obraLiterariaDto){
        System.out.println(obraLiterariaDto);
        return new ResponseEntity<>(service.saveObraLiteraria(obraLiterariaDto), HttpStatus.CREATED);
    }
    //OK
    @GetMapping("/getAll")
    public ResponseEntity<List<ObraLiterariaDto>> getAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    //OK
    @GetMapping("/autor/{name}")
    public ResponseEntity<List<ObraLiterariaDto>> getByAuthor(@PathVariable String name){
        return new ResponseEntity<>(service.findObrasByAuthor(name), HttpStatus.OK);
    }
    //OK
    @GetMapping("/obraLiteraria/{name}")
    public ResponseEntity<List<ObraLiterariaDto>> getByName(@PathVariable String name){
        return new ResponseEntity<>(service.findObrasByTitle(name), HttpStatus.OK);
    }
    //OK
    @GetMapping("/obraLiteraria/anio/{year}")
    public ResponseEntity<List<ObraLiterariaDto>> getByAnioPublicacionBefore(@PathVariable Integer year){
        return new ResponseEntity<>(service.findAllByAnioPublicacionBefore(year), HttpStatus.OK);
    }
    //OK
    @GetMapping("/obraLiteraria/editorial/{name}")
    public ResponseEntity<List<ObraLiterariaDto>> findAllByEditorial(@PathVariable String name){
        return new ResponseEntity<>(service.findAllByEditorial(name), HttpStatus.OK);
    }

    @GetMapping("/obraLiteraria/pages")
    public ResponseEntity<List<ObraLiterariaDto>> findObrasByQuantityPages(){
        return new ResponseEntity<>(service.findObrasByQuantityPages(), HttpStatus.OK);
    }
}
