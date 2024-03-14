package com.mercadolibre.elasticsearch_vivo.controller;

import com.mercadolibre.elasticsearch_vivo.dto.CreateLiteraryWorkDto;
import com.mercadolibre.elasticsearch_vivo.dto.LiteraryWorkResponseDto;
import com.mercadolibre.elasticsearch_vivo.entity.LiteraryWork;
import com.mercadolibre.elasticsearch_vivo.service.ILiteraryWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LiteraryController {
    private final ILiteraryWorkService literaryWorkService;

    @PostMapping("/literary")
    public ResponseEntity<LiteraryWorkResponseDto> createLiterary(@RequestBody CreateLiteraryWorkDto literaryWork){
        return ResponseEntity.ok(literaryWorkService.createLiteraryWork(literaryWork));
    }

    @GetMapping("/literary-by-author")
    public ResponseEntity<List<LiteraryWorkResponseDto>> getLiteraryWorkByAuthor(@RequestParam String author){
        return ResponseEntity.ok(literaryWorkService.getAllLiteraryWorksByAuthor(author));
    }

    @GetMapping("/literary-by-word-title")
    public ResponseEntity<List<LiteraryWorkResponseDto>> getLiteraryWorksByName(@RequestParam String name){
        return ResponseEntity.ok(literaryWorkService.getAllLiteraryWorksByName(name));
    }

    @GetMapping("/literary-by-top-5-page-count")
    public ResponseEntity<List<LiteraryWorkResponseDto>> getTop5LiteraryWorksOrderByPageCountDesc(){
        return ResponseEntity.ok(literaryWorkService.getTop5LiteraryWorksOrderByPageCountDesc());
    }

//    @GetMapping("/literary-by-editorial")
//    public ResponseEntity<List<LiteraryWorkResponseDto>> getLiteraryWork(@RequestParam(required = false) String editorial){
//        return ResponseEntity.ok(literaryWorkService.getAllLiteraryWorks());
//    }
}
