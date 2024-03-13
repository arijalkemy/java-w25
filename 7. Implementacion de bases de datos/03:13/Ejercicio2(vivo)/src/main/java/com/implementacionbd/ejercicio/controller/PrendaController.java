package com.implementacionbd.ejercicio.controller;

import java.util.List;

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

import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.dto.PrendaDTO;
import com.implementacionbd.ejercicio.service.PrendaService;

@RestController
@RequestMapping("/clothes")
public class PrendaController {
    private final PrendaService prendaService;

    public PrendaController(PrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PrendaDTO>> findAllPrendas() {
        List<PrendaDTO> prendaDTOs = prendaService.findAllPrendas();
        return new ResponseEntity<>(prendaDTOs, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/code/{id}")
    public ResponseEntity<PrendaDTO> findPrendaById(@PathVariable String id) {
        PrendaDTO prendaDTO = prendaService.findPrendaById(id);
        return new ResponseEntity<>(prendaDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaDTO>> findPrendaBySize(@PathVariable String size) {
        List<PrendaDTO> prendaDTOs = prendaService.findPrendaBySize(size);
        return new ResponseEntity<>(prendaDTOs, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<PrendaDTO>> findPrendaTipo(@PathVariable String tipo) {
        List<PrendaDTO> prendaDTOs = prendaService.findPrendaTipo(tipo);
        return new ResponseEntity<>(prendaDTOs, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deletePrenda(@PathVariable String id) {
        MessageDTO messageDTO = prendaService.deletePrenda(id);
        return new ResponseEntity<>(messageDTO, HttpStatusCode.valueOf(204));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaDTO> putTestCase(@PathVariable String id,
            @RequestBody PrendaDTO prendaDTO) {
        PrendaDTO prendaDTORes = prendaService.putPrenda(id, prendaDTO);
        return new ResponseEntity<>(prendaDTORes, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/")
    public ResponseEntity<MessageDTO> postTestCase(@RequestBody PrendaDTO prendaDTO) {
        MessageDTO messageDTO = prendaService.postPrenda(prendaDTO);
        return new ResponseEntity<>(messageDTO, HttpStatusCode.valueOf(201));
    }

}
