package com.ValentinCampestri.ObrasLiterarias.controller;

import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.service.IServiceObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.service.ServiceObraLiteraria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obrasliterarias")
public class ControllerObraLiteraria {
    IServiceObraLiteraria service;

    public ControllerObraLiteraria(ServiceObraLiteraria service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> cargarObras(@RequestBody ObraLiterariaDto dto){
        return new ResponseEntity<>(service.cargarObras(dto), HttpStatus.CREATED);
    }

    @PostMapping("/batchcreate")
    public ResponseEntity<?> cargarObrasBatch(@RequestBody List<ObraLiterariaDto> listaDto){
        return new ResponseEntity<>(service.cargarObrasBatch(listaDto), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> buscarTodasLasObras(){
        System.out.println("Le pego a endpoint");
        return new ResponseEntity<>(service.traerTodas(), HttpStatus.OK);
        // return null;
    }
}
