package com.mercadolibre.joyeria_las_perlas.controller;

import com.mercadolibre.joyeria_las_perlas.dto.JewelGetResponse;
import com.mercadolibre.joyeria_las_perlas.dto.JewelPostRequest;
import com.mercadolibre.joyeria_las_perlas.dto.JewelPostResponse;
import com.mercadolibre.joyeria_las_perlas.model.Jewel;
import com.mercadolibre.joyeria_las_perlas.service.IJewelService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jewelry")
public class JewelController {
    private final IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<JewelPostResponse> createJewel(@RequestBody JewelPostRequest jewelPostRequest){
        return ResponseEntity.ok(jewelService.createJewel(jewelPostRequest));
    }
    @GetMapping("/")
    public ResponseEntity<List<JewelGetResponse>> getAllRegisteredJewels(){
        return ResponseEntity.ok(jewelService.getAllRegisteredJewels());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JewelGetResponse> deleteJewel(@PathVariable Long id){
        return ResponseEntity.ok(jewelService.deleteJewel(id));
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<JewelGetResponse> updateJewel(
            @PathVariable Long id,
            @RequestBody JewelPostRequest newJewelRequest
    ){
        return ResponseEntity.ok(jewelService.updateJewel(id, newJewelRequest));
    }
}
