package com.bootcamp.ejercicio_mini_series.controller;

import com.bootcamp.ejercicio_mini_series.dto.request.MiniserieRequestDTO;
import com.bootcamp.ejercicio_mini_series.dto.response.MiniserieResponseDTO;
import com.bootcamp.ejercicio_mini_series.service.IMiniserieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/miniseries")
public class MiniserieController {
    private final IMiniserieService miniserieService;

    public MiniserieController(IMiniserieService miniserieService) {
        this.miniserieService = miniserieService;
    }

    @GetMapping
    public ResponseEntity<List<MiniserieResponseDTO>> getAllMiniseries() {
        return ResponseEntity.ok(miniserieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniserieResponseDTO> getOneMiniserie(@PathVariable("id") Long id) {
        return ResponseEntity.ok(miniserieService.findMiniserieById(id));
    }


    @PostMapping
    public ResponseEntity<?> createMiniSerie( @RequestBody MiniserieRequestDTO miniseerie){
        miniserieService.save(miniseerie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<MiniserieResponseDTO> getOneMiniserie(@PathVariable("name") String name) {
        return ResponseEntity.ok(miniserieService.getByName(name));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        miniserieService.deleteById(id);
    }

}
