package com.example.elasticDemo.controller;

import com.example.elasticDemo.dto.SaleDTO;
import com.example.elasticDemo.services.ISaleService;
import com.example.elasticDemo.services.SaleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

public class SalesController {

    private ISaleService service;

    public SalesController(SaleServiceImpl service){
        this.service = service;
    }


    /**
     * Crear una nueva venta.
     * @param ventaDto DTO de venta
     * @return DTO de venta + Status Created (201)
     */
    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody SaleDTO ventaDto){
        return new ResponseEntity<>(service.create(ventaDto), HttpStatus.CREATED);
    }

    /**
     * Devuelve un listado de todas las ventas cargadas
     * @return List de DTO de venta
     */
    @GetMapping
    public ResponseEntity<?> getAllSales(){
        return ResponseEntity.ok().body(service.findAll());
    }

    /**
     * Devuelve un venta específica
     * @param saleNumber numero identificador de una venta
     * @return DTO de venta buscada
     */
    @GetMapping("/{number}")
    public ResponseEntity<?> getOneSale(@PathVariable("number") Long saleNumber){
        return ResponseEntity.ok().body(service.findById(saleNumber));
    }

    /**
     * Actualizar una venta en particular
     * @param saleNumber numero identificador de una venta
     * @param newSale DTO de venta con informacion actualizada
     * @return DTO de venta actualizado
     */
    @PutMapping("/{number}") // CORREGIR Y PONER EL ID EN UPDATE POR PARTE DEL PATH
    public ResponseEntity<?> updateOneSale(@PathVariable("number") Long saleNumber, @RequestBody SaleDTO newSale){
        return ResponseEntity.ok().body(service.update(newSale));
    }

    /**
     * Eliminar una venta en particular
     * @param saleNumber numero identificador de una venta
     * @return DTO de venta eliminado
     */
    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteOneSale(@PathVariable("number") Long saleNumber){
        return ResponseEntity.ok().body(service.delete(saleNumber));
    }

    /**
     * Traer todas las prendas de una determinada fecha
     * @param date fecha a buscar
     * @return Listado de DTO de Venta filtrado por fecha
     */
    @GetMapping("/date")
    public ResponseEntity<?> getSalesByDate(@RequestParam("date") LocalDate date){
        return ResponseEntity.ok().body(service.findAllByFecha(date));
    }

    /**
     * Traer la lista completa de prendas de una determinada venta.
     * @param saleNumber numero identificador de una venta
     * @return Listado de DTO de Prenda de una venta en especifico
     */
    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getPrendasBySaleNumber(@PathVariable("number") Long saleNumber){
        return ResponseEntity.ok().body(service.findClothesBySale(saleNumber));
    }
}
