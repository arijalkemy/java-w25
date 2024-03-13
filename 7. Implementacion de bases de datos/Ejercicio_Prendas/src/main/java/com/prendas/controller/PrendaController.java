package com.prendas.controller;

import com.prendas.dto.PrendaDto;
import com.prendas.dto.ResponseDto;
import com.prendas.service.IPrendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    private IPrendaService prendaService;

    public PrendaController(IPrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> agregarPrenda(@RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(prendaService.save(prendaDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PrendaDto>> obtenerPrendas(){
        return new ResponseEntity<>(prendaService.getCloths(), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaDto>> obtenerPrendaPorTalle(@PathVariable String size){
        return new ResponseEntity<>(prendaService.getClothBySize(size), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> obtenerPrendaPorCodigo(@PathVariable Long code){
        return new ResponseEntity<>(prendaService.getClotheByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> actualizarPrendaPorCodigo( @PathVariable Long code,
                                                        @RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(prendaService.updateClothe(code, prendaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> eliminarPrendaPorCodigo(@PathVariable Long code){
        return new ResponseEntity<>(prendaService.deleteClothe(code), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<PrendaDto>> obtenerPrendasByName(@RequestParam String name){
        return new ResponseEntity<>(prendaService.getClotheByName(name), HttpStatus.OK);
    }
}
