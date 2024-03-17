package com.meli.showroom.controller;

import com.meli.showroom.dto.PrendaDTO;
import com.meli.showroom.entity.Prenda;
import com.meli.showroom.repository.IPrendaRepository;
import com.meli.showroom.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    @Autowired
    IPrendaService service;

    @PostMapping()
    public ResponseEntity<?> savePrenda(@RequestBody PrendaDTO prendaDTO) {
        service.savePrenda(prendaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getPrendas(
            @RequestParam(required = false, name = "name", defaultValue = "") String name) {
        List<PrendaDTO> prendasList = name == null ? service.getPrendas() : service.getPrendasByNombre(name);
        return new ResponseEntity<>(prendasList, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getPrendasByCode(@PathVariable Long code){
        return new ResponseEntity<>(service.getPrenda(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updatePrenda(@PathVariable Long code, @RequestBody PrendaDTO prendaDTO) {
        service.updatePrenda(code, prendaDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deletePrendasByCode(@PathVariable Long code){
        service.deletePrenda(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getPrendasBySize(@PathVariable String size){
        return new ResponseEntity<>(service.getPrendasByTalla(size), HttpStatus.OK);
    }
    @PostMapping("/test")
    public void saveAll(@RequestBody List<PrendaDTO> prendas){
        service.saveAll(prendas);
    }
}
