package com.codigoMorse.introduccionSpringEnVivo.controller;

import com.codigoMorse.introduccionSpringEnVivo.model.Mensaje;
import com.codigoMorse.introduccionSpringEnVivo.service.MensajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MensajeController {

    @GetMapping("/codificar/{mensaje}")
    public Mensaje codificarMensaje(@PathVariable("mensaje") String mensaje){
        return new Mensaje(MensajeService.codificar(mensaje));
    }
    @GetMapping("/decodificar/{mensaje}")
    public Mensaje decodificarMensaje(@PathVariable("mensaje") String mensaje){
        return new Mensaje(MensajeService.decodificar(mensaje));
    }
}
