package com.bootcamp.ejercicio_showroom.controller;

import com.bootcamp.ejercicio_showroom.dto.request.VentaReqDto;
import com.bootcamp.ejercicio_showroom.dto.response.VentaRespDto;
import com.bootcamp.ejercicio_showroom.service.ISalesService;
import com.bootcamp.ejercicio_showroom.service.SaleServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class SalesController {

    ISalesService saleService;
    public SalesController(SaleServiceImpl saleService){
        this.saleService = saleService;
    }

    @PostMapping("")
    public ResponseEntity<VentaRespDto> addVenta(@RequestBody VentaReqDto ventaReqDto) {
        return new ResponseEntity<>(saleService.addVenta(ventaReqDto), HttpStatus.CREATED);
    }

    //GET Nico U
    ///api/sale
    //Devolver todas las ventas
    @GetMapping
    public ResponseEntity<?> getAllventas(){
        return new ResponseEntity<>(this.saleService.getAllSales(),HttpStatus.OK);
    }

    //GET
    //
    ///api/sale/{number}
    //
    //Devolver una venta en particular
    //
    @GetMapping("/number/{number}")
    public ResponseEntity<?> getSaleByNumber(@PathVariable Long number) {
    return new ResponseEntity<>(this.saleService.getSaleByNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<VentaRespDto> updateVenta(@PathVariable Long number, @RequestBody VentaReqDto ventaReqDto) {
        return new ResponseEntity<>(saleService.updateVenta(number, ventaReqDto), HttpStatus.OK);
    }

    //DELETE
    //
    ///api/sale/{number]
    //
    //Eliminar una venta en particular
    //
    @DeleteMapping("/sale/{code}")
    public ResponseEntity<?> deleteSaleById(@PathVariable Long code){
    return new ResponseEntity<>(saleService.deleteSaleById(code), HttpStatus.OK);
    }

    //GET
    //
    ///api/sale?date=22/05/2022
    //
    //Traer todas las prendas de una determinada fecha
    @GetMapping("/sale")
    public ResponseEntity<?> getSalesOnDate(@RequestParam String date){
        return new ResponseEntity<>(saleService.getSalesOnDate(date), HttpStatus.OK);
    }

    ///api/sale/clothes/{number}
    //
    //Traer la lista completa de prendas de una determinada venta.
    @GetMapping("/cloth/{number}")
    public ResponseEntity<?> getSaleClothes(@PathVariable Long number){
        return new ResponseEntity<>(saleService.getClothesBySaleNumber(number), HttpStatus.OK);
    }
}
