package com.example.showroom.controller;


import com.example.showroom.dto.request.SaleReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;
import com.example.showroom.dto.response.SaleDto;
import com.example.showroom.service.ISalesService;
import com.example.showroom.service.SalesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SalesController {

    private ISalesService salesService;

    public SalesController(SalesServiceImpl salesService){
        this.salesService= salesService;
    }

    //Crear una nueva venta.
    @PostMapping("")
    public ResponseEntity<ConfirmationMessage> saveClothes(@RequestBody SaleReqDto saleDto){
        return new ResponseEntity<>(salesService.saveNewSale(saleDto), HttpStatus.CREATED);
    }

    //Devolver todas las ventas
    @GetMapping("")
    public ResponseEntity<List<SaleDto>> getAllSales(){
        return new ResponseEntity<>(salesService.getAllSales(), HttpStatus.OK);
    }
    //Devolver una venta en particular

    @GetMapping("/getByCode/{number}")
    public ResponseEntity<SaleDto> getSaleByCode(@PathVariable Long number){
        return new ResponseEntity<>(salesService.getSaleById(number), HttpStatus.OK);
    }

    //Actualizar una venta en particular
    @PutMapping("/{number}")
    public ResponseEntity<ConfirmationMessage> updateClothes(@RequestBody SaleReqDto saleDto, @PathVariable Long number){
        return new ResponseEntity<>(salesService.updateSale(saleDto, number), HttpStatus.CREATED);
    }
    //Eliminar una venta en particular
    @DeleteMapping("/{number}")
    public ResponseEntity<ConfirmationMessage> deleteSaleByCode(@PathVariable Long number){
        return new ResponseEntity<>(salesService.deleteSaleById(number), HttpStatus.OK);
    }
    //Traer todas las prendas de una determinada fecha
    @GetMapping("/getByDate")
    public ResponseEntity<List<SaleDto>> getClothesByDate(@RequestParam("date") LocalDate date){
        return new ResponseEntity<>(salesService.getSaleByDate(date), HttpStatus.CREATED);
    }
    //Traer la lista completa de prendas de una determinada venta.
    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClotheDto>> getClothesBySale(@PathVariable Long number){
        return new ResponseEntity<>(salesService.getListClothesById(number), HttpStatus.CREATED);
    }
}
