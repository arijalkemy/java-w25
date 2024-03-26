package com.practicas.MiniSeries.controller;

import com.practicas.MiniSeries.model.MiniSerie;
import com.practicas.MiniSeries.service.MiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiniSerieController {
    MiniSerieService miniSerieService;

    public MiniSerieController(MiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @GetMapping("/miniserie")
    public ResponseEntity<MiniSerie> getMiniserieByName(@RequestParam String name){
        return new ResponseEntity<>(miniSerieService.getMiniserieByName(name), HttpStatus.OK);
    }

    @PostMapping("/miniserie")
    public ResponseEntity<MiniSerie> addMiniserie(@RequestBody MiniSerie miniSerie){
        return new ResponseEntity<>(miniSerieService.addMiniSerie(miniSerie), HttpStatus.CREATED);
    }
}
