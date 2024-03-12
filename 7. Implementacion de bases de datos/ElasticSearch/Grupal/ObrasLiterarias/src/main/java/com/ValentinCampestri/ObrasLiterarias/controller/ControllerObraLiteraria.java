package com.ValentinCampestri.ObrasLiterarias.controller;

import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.service.IServiceObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.service.ServiceObraLiteraria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Obrasliterarias")
public class ControllerObraLiteraria {
    IServiceObraLiteraria service;

    public ControllerObraLiteraria(ServiceObraLiteraria service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?>cargarObras(@RequestBody ObraLiterariaDto dto){
        return new ResponseEntity<>(service.cargarObras(dto), HttpStatus.CREATED);
    }
}
