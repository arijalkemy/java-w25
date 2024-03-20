package com.example.vehiculossiniestros.controller;

import com.example.vehiculossiniestros.dto.VehiculoDto;
import com.example.vehiculossiniestros.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vehicle")
public class VehiculoController {

  private IVehiculoService vehiculoService;

  public VehiculoController(IVehiculoService vehiculoService){
    this.vehiculoService = vehiculoService;
  }

  @PostMapping("")
  public ResponseEntity<VehiculoDto> createVehicle(@RequestBody VehiculoDto vehiculoDto){
    return new ResponseEntity<>(vehiculoService.createVehicle(vehiculoDto), HttpStatus.OK);
  }

  @GetMapping("")
  public ResponseEntity<List<VehiculoDto>> getAllVehicles(){
    return null;
  }

  @GetMapping("/patente")
  public ResponseEntity<?> getAllPatents() {
    return new ResponseEntity<>(vehiculoService.getAllPatents(), HttpStatus.OK);
  }

  @GetMapping("/patente_marca")
  public ResponseEntity<?> getAllPatentsAndBrands() {
    return new ResponseEntity<>(vehiculoService.getAllPatentsAndBrands(), HttpStatus.OK);
  }

  @GetMapping("/cuatro_ruedas")
  public ResponseEntity<?> getFourWheelsAndCurrentYearVehicles() {
    return new ResponseEntity<>(vehiculoService.getFourWheelsAndCurrentYearVehicles(), HttpStatus.OK);
  }

  @GetMapping("/siniestros/info")
  public ResponseEntity<?> getMajorsSinisterInfo() {
    return new ResponseEntity<>(vehiculoService.getMajorsSinisterInfo(), HttpStatus.OK);
  }

  @GetMapping("/siniestros/full")
  public ResponseEntity<?> getMajorsSinisterFullInfo() {
    return new ResponseEntity<>(vehiculoService.getMajorsSinisterFullInfo(), HttpStatus.OK);
  }

}
