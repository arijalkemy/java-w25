package me.davidlake.proyectocodigomorse.controller;

import me.davidlake.proyectocodigomorse.helpers.Helpers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {
    @GetMapping("/toMorse/{mensaje}")
    public String translateToMorse(@PathVariable String mensaje) {
        return Helpers.encriptMessage(mensaje);
    }

    @GetMapping("/fromMorse/{mensaje}")
    public String translateFromMorse(@PathVariable String mensaje) {
        return Helpers.decriptMessage(mensaje);
    }
}