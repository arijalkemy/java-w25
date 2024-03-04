package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.response.ResponseEntradaDTO;
import com.mercadolibre.blog.dto.response.ResponseIdMensajeDTO;
import com.mercadolibre.blog.service.BlogService;
import com.mercadolibre.blog.dto.request.RequestEntradaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping()
    public ResponseEntity<ResponseIdMensajeDTO> addEntry(@RequestBody RequestEntradaDTO requestEntradaDTO) {
        return new ResponseEntity<>(blogService.addEntry(requestEntradaDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntradaDTO> getEntryById(@PathVariable int id) {
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<ResponseEntradaDTO>> getAllEntries() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }
}
