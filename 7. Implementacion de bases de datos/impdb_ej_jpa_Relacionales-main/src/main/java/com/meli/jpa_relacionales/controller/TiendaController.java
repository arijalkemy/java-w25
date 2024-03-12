package com.meli.jpa_relacionales.controller;

import com.meli.jpa_relacionales.service.ITiendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiendaController {
    private ITiendaService service;

    public TiendaController(ITiendaService service) {
        this.service = service;
    }






}
