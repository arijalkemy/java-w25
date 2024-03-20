package org.example.seguros.controller;

import org.example.seguros.service.ISiniestroService;
import org.example.seguros.service.impl.SiniestroService;

public class SiniestroController {
    private final ISiniestroService siniestroService;
    public SiniestroController(SiniestroService siniestroService){
        this.siniestroService = siniestroService;
    }
}
