package com.mercadolibre.clave_compuesta.controller;

import com.mercadolibre.clave_compuesta.model.Compra;
import com.mercadolibre.clave_compuesta.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compras")
public class CompraController {
    private final CompraRepository repository;
    @PostMapping("/")
    public ResponseEntity<Compra> createCompra(@RequestBody Compra newCompra){
        return ResponseEntity.ok(repository.save(newCompra));
    }
    @GetMapping("/")
    public ResponseEntity<List<Compra>> getAllCompras(){
        return ResponseEntity.ok(repository.findAll());
    }
}
