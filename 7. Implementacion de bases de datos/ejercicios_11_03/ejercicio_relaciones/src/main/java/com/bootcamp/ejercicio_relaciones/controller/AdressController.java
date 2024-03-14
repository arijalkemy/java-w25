package com.bootcamp.ejercicio_relaciones.controller;

import com.bootcamp.ejercicio_relaciones.dto.AdressDTO;
import com.bootcamp.ejercicio_relaciones.dto.ResponseDTO;
import com.bootcamp.ejercicio_relaciones.service.IAdressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController {
    private final IAdressService adressService;

    public AdressController(IAdressService adressService) {
        this.adressService = adressService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestBody AdressDTO adress) {
        return ResponseEntity.ok(adressService.save(adress));
    }
    @GetMapping("/all")
    public ResponseEntity<List<AdressDTO>> getAll() {
        return ResponseEntity.ok(adressService.getAll());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(adressService.delete(id));
    }

}
