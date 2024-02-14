package com.bootcamp.clase9feb.calculadoraCalorias.controller;

import com.bootcamp.clase9feb.calculadoraCalorias.dto.response.PlatoDTO;
import com.bootcamp.clase9feb.calculadoraCalorias.services.PlatoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    PlatoServiceImp platoService;

    public PlatoController (PlatoServiceImp platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/platos")
    public ResponseEntity<PlatoDTO> getByName (@RequestParam String name,
                                               @RequestParam String peso){
        PlatoDTO platoBuscado = platoService.getByName(name);
        return ResponseEntity.ok(null);
    }
}
