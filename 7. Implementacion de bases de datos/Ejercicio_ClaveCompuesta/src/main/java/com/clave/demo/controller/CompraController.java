package com.clave.demo.controller;

import com.clave.demo.dto.CompraDTO;
import com.clave.demo.service.ICompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private ICompraService compraService;

    public CompraController(ICompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> publicarCompra(@RequestBody CompraDTO compra) {
        return new ResponseEntity<>(compraService.createCompra(compra), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerCompras() {
        return new ResponseEntity<>(compraService.getAll(), HttpStatus.OK);
    }
}
