package com.showroomAPI.controller;

import com.showroomAPI.dto.request.PrendaDto;
import com.showroomAPI.service.IPrendaService;
import com.showroomAPI.service.PrendaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private final IPrendaService prendaService;

    public PrendaController(PrendaServiceImpl prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping("")
    public ResponseEntity<?> createPrenda (@RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(prendaService.createPrenda(prendaDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getPrendas (){
        return new ResponseEntity<>(prendaService.getPrendas(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getPrendaByCode (@PathVariable Long code){
        return new ResponseEntity<>(prendaService.getPrendaByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updatePrendaByCode (@PathVariable Long code, @RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(prendaService.updatePrendaByCode(code,prendaDto), HttpStatus.OK);
    }

}
