package com.mercadolibre.demow25.controller;

import com.mercadolibre.demow25.dto.EntryMorseDto;
import com.mercadolibre.demow25.dto.Morsedto;
import com.mercadolibre.demow25.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @Autowired
    MorseService morseService;

    @PostMapping("/encode")
    public ResponseEntity<Morsedto> encodeMorse(@RequestBody EntryMorseDto entry) {
        return new ResponseEntity<>(morseService.decodeEntry(entry.getEntry()), HttpStatus.OK);
    }

    @PostMapping("/decode")
    public  ResponseEntity<Morsedto> decodeMorse(@RequestBody EntryMorseDto entry){
        return new ResponseEntity<>(morseService.encodeEntry(entry.getEntry()), HttpStatus.OK);
    }
}
