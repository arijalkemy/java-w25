package com.example.ElasticDemo01.controller;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.dto.ObraLiterariaFiltrosDTO;
import com.example.ElasticDemo01.service.ObraLiterariaServiceImpl;
import com.example.ElasticDemo01.service.ObraLiterariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/book")
@RestController
public class ObraLiterariaController {

    private ObraLiterariaService service;

    public ObraLiterariaController(ObraLiterariaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody ObraLiterariaDTO obraLiterariaDTO){
        return new ResponseEntity<>(service.saveBook(obraLiterariaDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTopFive(){
        return new ResponseEntity<>(service.getTop5ByCantPag(),HttpStatus.OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getAllByAutor(@PathVariable String autor){
        ObraLiterariaFiltrosDTO obraLiterariaFiltrosDTO = new ObraLiterariaFiltrosDTO();
        obraLiterariaFiltrosDTO.setAutor(autor);
        return new ResponseEntity<>(service.getObraByAutor(obraLiterariaFiltrosDTO),HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getAllByEditorial(@PathVariable String editorial){
        ObraLiterariaFiltrosDTO obraLiterariaFiltrosDTO = new ObraLiterariaFiltrosDTO();
        obraLiterariaFiltrosDTO.setEditorial(editorial);
        return new ResponseEntity<>(service.getByEditorial(obraLiterariaFiltrosDTO),HttpStatus.OK);
    }

    @GetMapping("/before")
    public ResponseEntity<?> getBefore(@RequestBody ObraLiterariaFiltrosDTO obraLiterariaFiltrosDTO){
        return new ResponseEntity<>(service.getBeforeDate(obraLiterariaFiltrosDTO),HttpStatus.OK);
    }

    @GetMapping("/palabraclave")
    public ResponseEntity<?> getByPalabraClave(@RequestBody ObraLiterariaFiltrosDTO obraLiterariaFiltrosDTO){
        return new ResponseEntity<>(service.getObraByPalabraClave(obraLiterariaFiltrosDTO),HttpStatus.OK);
    }

}
