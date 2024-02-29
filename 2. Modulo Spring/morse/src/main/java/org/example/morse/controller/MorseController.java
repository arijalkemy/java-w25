package org.example.morse.controller;

import org.example.morse.dto.ResponseDto;
import org.example.morse.service.impl.MorseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("morse")
public class MorseController {
    private final MorseService morseService;

    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @GetMapping("/to_words/{morsecode}")
    public ResponseEntity<ResponseDto> convertMorseToWords(@PathVariable String morsecode) {
        return new ResponseEntity<ResponseDto>(
                this.morseService.convertMorseToWords(morsecode),
                HttpStatus.OK
        );
    }
    @GetMapping("/to_morse/{words}")
    public ResponseEntity<ResponseDto> convertWordsToMorse(@PathVariable String words) {
        return new ResponseEntity<ResponseDto>(
                this.morseService.convertWordsToMorse(words),
                HttpStatus.OK
        );
    }
}
