package com.bootcamp.ejercicio_showroom.controller;

import com.bootcamp.ejercicio_showroom.dto.request.PrendaRequDto;
import com.bootcamp.ejercicio_showroom.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom.service.ClothesServiceImpl;
import com.bootcamp.ejercicio_showroom.service.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clothes")
public class ShowroomController {
    IClothesService clothesService;

    public ShowroomController(ClothesServiceImpl clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping("")
    public ResponseEntity<PrendaRespDto> addPrenda(@RequestBody PrendaRequDto requDto) {
        return new ResponseEntity<>(clothesService.addPrenda(requDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllClothes() {
        return new ResponseEntity<>(this.clothesService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<?> getClothesByCode(@PathVariable Long code){
        return new ResponseEntity<>(this.clothesService.getClothesByCode(code),HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<PrendaRespDto> updatePrenda(@PathVariable Long code, @RequestBody PrendaRequDto requDto) {
        return new ResponseEntity<>(clothesService.updatePrenda(code, requDto), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothesById(@PathVariable Long code) {
        return new ResponseEntity<>(clothesService.deleteClothesById(code),HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothesService.getClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getClothesByKeyword(@RequestParam String word) {
        return new ResponseEntity<>(clothesService.getClothesByWord(word), HttpStatus.OK);
    }
}
