package com.example.ejercicio_seguros.controller;

import com.example.ejercicio_seguros.dto.MensajeDTO;
import com.example.ejercicio_seguros.dto.VehiculoDTO;
import com.example.ejercicio_seguros.service.IVehiculoService;
import com.example.ejercicio_seguros.service.VehiculoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(VehiculoServiceImpl vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("")
    public ResponseEntity<List<VehiculoDTO>> listVehiculos(){
        return ResponseEntity.ok().body(this.vehiculoService.listVehiculos());
    }

    @PostMapping("")
    public ResponseEntity<MensajeDTO> saveVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return ResponseEntity.ok().body(this.vehiculoService.guardarVehiculo(vehiculoDTO));
    }
    @PostMapping("/bulk")
    public ResponseEntity<List<MensajeDTO>> saveVehiculos(@RequestBody List<VehiculoDTO> list){
        List<MensajeDTO> result = list.stream().map(
                this.vehiculoService::guardarVehiculo).toList();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getAllPatentes(){
        return ResponseEntity.ok().body(this.vehiculoService.listPatentesVehiculos());
    }

    @GetMapping("/patentes&marca")
    public ResponseEntity<?> geetAllPatentesAndMarcas(){
        return ResponseEntity.ok().body(this.vehiculoService.listPatentesVehiculos());
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> getAllPatenteByRuedasAndAnio(@RequestParam Integer cantRuedas, @RequestParam Integer anio){
        return ResponseEntity.ok().body(this.vehiculoService.listPatentesVehiculosByRuedasAndAnio(cantRuedas,anio));
    }

    @GetMapping("/siniestro")
    public ResponseEntity<?> getAllVehiculosByPerdida(@RequestParam double perdida){
        return ResponseEntity.ok().body(this.vehiculoService.listVehiculoSiniestroByPerdida(perdida));
    }

    @GetMapping("/siniestroTotal")
    public ResponseEntity<?> geetAllSiniestroTotal(){
        return ResponseEntity.ok().body(this.vehiculoService.listVehiculoSiniestroByPerdidaTotal(10000));
    }

}
