package com.mercadolibre.hql_seguro_autos.controller;

import com.mercadolibre.hql_seguro_autos.dto.request.CreateVehiculoDto;
import com.mercadolibre.hql_seguro_autos.dto.response.*;
import com.mercadolibre.hql_seguro_autos.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehiculos-siniestros")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    @PostMapping("/create")
    public ResponseEntity<VehicleDto> createVehiculoWithSiniestros(@RequestBody CreateVehiculoDto createVehiculoDto){
        return ResponseEntity.ok(vehiculoService.create(createVehiculoDto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<PatenteDto>> getAllPatentes(){
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }
    @GetMapping("/ordered-by-fabrication-year")
    public ResponseEntity<List<PatenteMarcaDto>> getAllPatentesAndMarcasOrderedByAnioFabricacion(){
        return ResponseEntity.ok(vehiculoService.findPatenteAndMarcaOrderByAnioFabricacion());
    }
    @GetMapping("/more-than-4-wheels-current-year")
    public ResponseEntity<List<PatenteDto>> getAllPatentesWithMoreThan4WheelsAndCurrentYear(){
        return ResponseEntity.ok(vehiculoService.findPatentesWithMoreThan4WheelsAndCurrentYear());
    }
    @GetMapping("/perdidas-greather-than-10000")
    public ResponseEntity<List<PatenteMarcaModeloDto>> getAllMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan10000(){
        return ResponseEntity.ok(vehiculoService.findMarcaPatenteModeloWithSiniestrosWithPerdidasGreaterThan10000());
    }
    @GetMapping("/perdidas-sum-greather-than-10000")
    public ResponseEntity<VehiculoSiniestroDto> getAllPerdidasSumMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan10000(){
        return ResponseEntity.ok(vehiculoService.findPerdidasSumMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan10000());
    }
}
