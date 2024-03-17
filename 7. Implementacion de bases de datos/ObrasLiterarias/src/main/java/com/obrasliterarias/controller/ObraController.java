package com.obrasliterarias.controller;

import com.obrasliterarias.dto.request.ObraDTO;
import com.obrasliterarias.repository.IObraRepository;
import com.obrasliterarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/obra")
@RestController
public class ObraController {


    private final IObraService obraService;

    public ObraController(IObraService obraService){
        this.obraService = obraService;
    }

    @PostMapping("")
    public ResponseEntity<?> createObra(@RequestBody ObraDTO obraDTO){
        return new ResponseEntity<>(obraService.createObra(obraDTO),HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> getObra(){
        return new ResponseEntity<>(obraService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getObraByAutor(@PathVariable String autor){
        return new ResponseEntity<>(obraService.getObraByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getObraByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(obraService.getObraByContainsInNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<?> getObraBeforeAnio(@PathVariable Integer anio){
        return new ResponseEntity<>(obraService.getObrasByAnioBefore(anio), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getObraByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(obraService.getObrasByEditorial(editorial), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getObraTop(){
        return new ResponseEntity<>(obraService.getObraTopPaginas(), HttpStatus.OK);
    }
}
