package com.mercadolibre.empresadeseguros.controller;

import com.mercadolibre.empresadeseguros.dto.request.CreateSiniestroDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sinientro")
public class SiniestroController {

    //TODO: agregar el service

    @GetMapping("/all")
    public ResponseEntity<?> getAllSiniestros(){
        return ResponseEntity.ok().body(null);
    }
    @PostMapping("/new")
    public ResponseEntity<?> postSiniestro(@RequestBody CreateSiniestroDto createSiniestroDto){
        return ResponseEntity.created(null).build();
    }
}
