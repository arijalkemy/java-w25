package com.meli.showroom.controller;

import com.meli.showroom.dto.PrendaDTO;
import com.meli.showroom.dto.ResponseDTO;
import com.meli.showroom.dto.VentaDTO;
import com.meli.showroom.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    @Autowired
    IVentaService ventaService;

    @PostMapping("")
    public ResponseEntity<VentaDTO> createVenta(@RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.newVenta(ventaDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VentaDTO>> getAllVentas(@RequestParam String date){
        if(date == null){
            return new ResponseEntity<>(ventaService.getAllVentas(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(ventaService.getVentasByDate(date), HttpStatus.OK);
        }
    }

    @GetMapping("/{number}")
    public ResponseEntity<VentaDTO> getVentaByNumber(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.getVentaByNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<VentaDTO> updateVentaByNumber(@PathVariable Long number, @RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.updateVenta(ventaDTO, number), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<ResponseDTO> deleteVentaByNumber(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.deleteVentaByNumber(number), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaDTO>> getClothesByVenta(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.getPrendasFromVenta(number), HttpStatus.OK);
    }

    @PostMapping("/createAll")
    public ResponseEntity<List<VentaDTO>> createAllVentas(@RequestBody List<VentaDTO> ventaDTOS){
        return new ResponseEntity<>(ventaService.saveAll(ventaDTOS), HttpStatus.OK);
    }
}
