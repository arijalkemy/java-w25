package com.example.configurando_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.configurando_jpa.dto.MiniSerieDto;
import com.example.configurando_jpa.dto.res.MessageDto;
import com.example.configurando_jpa.model.MiniSerie;
import com.example.configurando_jpa.service.IMiniSerieService;

@RestController
@RequestMapping("/miniseries")
public class MiniSerieController {
    @Autowired
    private IMiniSerieService iMiniSerieService;

    @GetMapping("/getMiniSeries")
    public ResponseEntity<List<MiniSerie>> getMiniSeries() {
        List<MiniSerie> miniSeriesList = iMiniSerieService.getMiniSeries();
        return new ResponseEntity<>(miniSeriesList, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/saveMiniSerie")
    public ResponseEntity<MessageDto> saveMiniSerie(@RequestBody MiniSerieDto miniSerieDto) {
        MessageDto messageDto = iMiniSerieService.saveMiniSerie(miniSerieDto);
        return new ResponseEntity<>(messageDto, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/deleteMiniSerie/{id}")
    public ResponseEntity<MessageDto> deleteMiniSerie(@PathVariable long id) {
        MessageDto messageDto = iMiniSerieService.deleteMiniSerie(id);
        return new ResponseEntity<>(messageDto, HttpStatusCode.valueOf(204));
    }

    @PutMapping("editMiniSerie/{id}")
    public ResponseEntity<MiniSerieDto> editMiniSerie(@PathVariable long id,
            @RequestBody MiniSerieDto miniSerieDto) {
        MiniSerieDto miniSerie = iMiniSerieService.findMiniSerie(id);
        miniSerie.setName(miniSerieDto.getName());
        miniSerie.setRating(miniSerieDto.getRating());
        miniSerie.setAmountOfAwards(miniSerieDto.getAmountOfAwards());
        iMiniSerieService.saveMiniSerie(miniSerie);
        return new ResponseEntity<>(miniSerie, HttpStatusCode.valueOf(200));
    }

}
