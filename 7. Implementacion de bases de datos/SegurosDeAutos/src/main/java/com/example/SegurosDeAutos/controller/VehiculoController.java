package com.example.SegurosDeAutos.controller;

import com.example.SegurosDeAutos.dto.RequestVehiculoDTO;
import com.example.SegurosDeAutos.entity.Vehiculo;
import com.example.SegurosDeAutos.service.IVehiculoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final IVehiculoServices vehiculoService;
    public VehiculoController(IVehiculoServices vehiculoService){
        this.vehiculoService=vehiculoService;
    }

    @PostMapping("")
    public ResponseEntity<?> guardarVehiculo(@RequestBody RequestVehiculoDTO nuevoVehiculo){
        return ResponseEntity.ok(vehiculoService.addVehiculo(nuevoVehiculo));
    }

    @GetMapping("")
    public ResponseEntity<?> consultarVehiculos(){
        return ResponseEntity.ok(vehiculoService.getVehiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarVehiculoById(@PathVariable Long id){
        return ResponseEntity.ok(vehiculoService.getVehiculoById(id));
    }
}
