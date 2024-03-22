package com.mercadolibre.empresadeseguros.controller;

import com.mercadolibre.empresadeseguros.dto.request.CreateVehiculoDto;
import com.mercadolibre.empresadeseguros.dto.response.VehiculoDto;
import com.mercadolibre.empresadeseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/all")
    public ResponseEntity<List<VehiculoDto>> getAllVehiculos(){
        return ResponseEntity.ok().body(
                this.vehiculoService.getAll()
        );
    }
    @PostMapping("/new")
    public ResponseEntity<VehiculoDto> postVehiculo(@RequestBody CreateVehiculoDto createVehiculoDto){
        VehiculoDto vehiculoDto = vehiculoService.create(createVehiculoDto);
        return new ResponseEntity<VehiculoDto>(
                    vehiculoDto,
                    HttpStatus.CREATED
        );
    }
}
