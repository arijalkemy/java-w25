package org.example.prendas.controller;

import org.example.prendas.dto.CreateSaleDTO;
import org.example.prendas.dto.SaleDTO;
import org.example.prendas.entity.Prenda;
import org.example.prendas.entity.Venta;
import org.example.prendas.service.IPrendaService;
import org.example.prendas.service.ISaleService;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
//@Mapping("api/sale")
public class VentaController {

    private ISaleService service;

    VentaController(ISaleService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<Venta> createSale(@RequestBody CreateSaleDTO body) {
        return ResponseEntity.ok(service.create(body));
    }

    @GetMapping()
    public ResponseEntity<List<Venta>> getSales(@RequestParam(value = "date", required = false) LocalDate date) {
        return ResponseEntity.ok(service.getSales(date));
    }

    @GetMapping("/{number}")
    public ResponseEntity<Venta> getSale(@PathVariable long number) {
        return ResponseEntity.ok(service.getSale(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<Venta> modifySale(@PathVariable long number, @RequestBody CreateSaleDTO body) {
        return ResponseEntity.ok(service.modify(number, body));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable long number) {
        return ResponseEntity.ok(service.delete(number));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<Prenda>> getSaleClothes(@PathVariable long number) {
        return ResponseEntity.ok(service.getSaleClothes(number));
    }

}
