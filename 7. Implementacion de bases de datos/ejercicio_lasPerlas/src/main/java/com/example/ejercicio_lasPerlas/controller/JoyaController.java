package com.example.ejercicio_lasPerlas.controller;

import com.example.ejercicio_lasPerlas.dto.NoIdJoyaDTO;
import com.example.ejercicio_lasPerlas.dto.response.JoyaDTO;
import com.example.ejercicio_lasPerlas.dto.response.SaveDTO;
import com.example.ejercicio_lasPerlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    ResponseEntity<SaveDTO> save(@RequestBody NoIdJoyaDTO noIdJoyaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaService.save(noIdJoyaDTO));
    }

    @PutMapping("/jewerly/update/{id}")
    ResponseEntity<NoIdJoyaDTO> update(@PathVariable("id") Long id, @RequestBody NoIdJoyaDTO noIdJoyaDTO) {
        return ResponseEntity.ok().body(joyaService.update(id, noIdJoyaDTO));
    }


    @GetMapping("/jewerly")
    ResponseEntity<List<JoyaDTO>> list() {
        return ResponseEntity.ok()
                .body(joyaService.list());
    }

    @DeleteMapping("/jewerly/delete/{id}")
    ResponseEntity<?> remove(@PathVariable("id") Long id) {
        joyaService.remove(id);
        return ResponseEntity.ok().build();
    }

}
