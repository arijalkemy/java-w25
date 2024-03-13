package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.dto.PlatesAndBrandsDTO;
import com.example.ejemplo_jpa.dto.SiniestroDTO;
import com.example.ejemplo_jpa.dto.VehiculoDTO;
import com.example.ejemplo_jpa.model.Siniestro;
import com.example.ejemplo_jpa.model.Vehiculo;
import com.example.ejemplo_jpa.service.VehiculoSiniestroService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class VehiculoSiniestroController {

    private VehiculoSiniestroService vehiculoSiniestroService;

    public VehiculoSiniestroController(VehiculoSiniestroService vehiculoSiniestroService) {
        this.vehiculoSiniestroService = vehiculoSiniestroService;
    }

    /*@GetMapping("/{name}")
    public List<Movie> findMoviesByTitle(
            @PathVariable String name
    ) {
        return vehiculoSiniestroService.getMoviesByName(name);
    }*/

    @PostMapping("/save/vehicle")
    public String createVehicle(
            @RequestBody
            VehiculoDTO vehiculoDTO
    ) {
        vehiculoSiniestroService.saveVehicle(vehiculoDTO);
        return "Vehiculo creado exitosamente";
    }

    @PostMapping("/save/siniestro")
    public String createSiniestro(
            @RequestBody
            SiniestroDTO siniestroDTO
    ) {
        vehiculoSiniestroService.saveSiniestro(siniestroDTO);
        return "Siniestro creado exitosamente";
    }

    @GetMapping("/get/vehiculos/patentes")
    public List<String> findPatentes() {
        return vehiculoSiniestroService.getAllPatentes();
    }

    @GetMapping("/get/vehiculos/patente/anio")
    public List<PlatesAndBrandsDTO> findPatentesYMarcasPorAnio() {
        return vehiculoSiniestroService.getAllVehiculosPatentesYMarcasPorAnio(); //o el nombre que le quede
    }

    /*@GetMapping("/get/vehiculos/ruedas/anio")
    public List<String> findVehiculosPlatesPorRuedasYAnioActual() {
        return vehiculoSiniestroService.getAllVehiculosPlatesPorRuedasYAnio(); //o el nombre que le quede
    }*/

    /*
    @GetMapping("/get/vehiculos/siniestro")
    public List<Vehiculo> findVehiculos() {
        return vehiculoSiniestroService.getAllVehiculosPorSiniestro(); //o el nombre que le quede
    }

    @GetMapping("/get/vehiculos/siniestro/perdida")
    public List<Vehiculo> findVehiculos() {
        return vehiculoSiniestroService.getAllVehiculosPorPerdida(); //o el nombre que le quede
    }*/

}
