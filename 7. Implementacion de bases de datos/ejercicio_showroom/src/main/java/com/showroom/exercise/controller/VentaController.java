package com.showroom.exercise.controller;

import com.showroom.exercise.dto.VentaDTO;
import com.showroom.exercise.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class VentaController {
    @Autowired
    IVentaService ventaService;

    @PostMapping("")
    public ResponseEntity<?> saveVenta(@RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.saveVenta(ventaDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllVentas(@RequestParam(required = false) String date){
        List<VentaDTO> ventaDTOList=date==null ? ventaService.getAllVentas() : ventaService.getVentasByDate(date);
        return new ResponseEntity<>(ventaDTOList, HttpStatus.OK);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> getVentaById(@PathVariable Long numero){
        return new ResponseEntity<>(ventaService.getVentaByNumber(numero), HttpStatus.OK);
    }

    @PutMapping("/{numero}")
    public ResponseEntity<?> modifyVenta(@PathVariable Long numero, @RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.updateVenta(numero, ventaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long numero){
        return new ResponseEntity<>(ventaService.deleteVenta(numero), HttpStatus.OK);
    }

    @GetMapping("/clothes/{numero}")
    public ResponseEntity<?> getPrendasFromVentaById(@PathVariable Long numero){
        return new ResponseEntity<>(ventaService.getPrendasFromVentaById(numero), HttpStatus.OK);
    }
}
