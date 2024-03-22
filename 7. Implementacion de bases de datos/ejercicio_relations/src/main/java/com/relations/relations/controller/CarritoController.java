package com.relations.relations.controller;

import com.relations.relations.dto.request.RequestCarritoDto;
import com.relations.relations.dto.response.GenericReponseDTO;
import com.relations.relations.dto.response.ResponseCarritoDto;
import com.relations.relations.service.ICarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarritoController {
    private ICarritoService carritoService;

    public CarritoController (ICarritoService carritoService){
        this.carritoService = carritoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponseCarritoDto>> getAll(){
        return ResponseEntity.ok(carritoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCarritoDto> getAll(@PathVariable Long id){
        return ResponseEntity.ok(carritoService.getById(id));
    }
    @PostMapping("/new")
    public ResponseEntity<GenericReponseDTO> create(@RequestBody RequestCarritoDto requestCarritoDto){
        return ResponseEntity.ok(carritoService.save(requestCarritoDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericReponseDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(carritoService.deleteById(id));
    }
}
