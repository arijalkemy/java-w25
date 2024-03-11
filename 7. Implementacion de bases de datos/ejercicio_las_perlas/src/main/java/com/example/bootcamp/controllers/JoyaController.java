package com.example.bootcamp.controllers;

import com.example.bootcamp.dto.JoyaDTO;
import com.example.bootcamp.dto.response.CreateResponseDTO;
import com.example.bootcamp.model.Joya;
import com.example.bootcamp.services.IJoyaService;
import com.example.bootcamp.services.JoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyaController {

    IJoyaService joyaService;

    public JoyaController(JoyaService joyaService){
        this.joyaService = joyaService;
    }

    @GetMapping("/jewerly")
    public ResponseEntity getAll(){
        joyaService.getAll();
        return ResponseEntity.ok(null);
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity createJoya(@RequestBody JoyaDTO joyaDTO){
        Joya j = joyaService.create(joyaDTO);
        return ResponseEntity.ok(new CreateResponseDTO("Creación exitosa", j.getId()));
    }

    @PatchMapping("/jewerly/update/{id}")
    public ResponseEntity updateJoya(@PathVariable Long id){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(" /jewerly/delete/{id}")
    public ResponseEntity deleteJoya(@PathVariable Long id){
        return ResponseEntity.ok(null);
    }


}
