package com.blog.ejercicio1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.ejercicio1.dto.request.EntradaBlogRequestDTO;
import com.blog.ejercicio1.dto.response.EntradaBlogIdResDTO;
import com.blog.ejercicio1.dto.response.EntradaBlogResponseDTO;
import com.blog.ejercicio1.exception.NotFoundException;
import com.blog.ejercicio1.service.EntradaBlogService;

@RestController
@RequestMapping("/api")
public class EntradaBlogController {
    @Autowired
    EntradaBlogService entBlogService;

    @PostMapping("/blogs")
    @ResponseBody
    public ResponseEntity<EntradaBlogIdResDTO> postEntradaBlog(@RequestBody EntradaBlogRequestDTO entradaBlogDTO) {
        return new ResponseEntity<>(entBlogService.postEntradaBlog(entradaBlogDTO), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/blogs")
    @ResponseBody
    public ResponseEntity<List<EntradaBlogResponseDTO>> getVehicles() {
        return new ResponseEntity<>(entBlogService.getAllEntradaBlog(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("blogs/{id}")
    @ResponseBody
    public ResponseEntity<EntradaBlogResponseDTO> getEntradaBlogById(@PathVariable Integer id) {
        EntradaBlogResponseDTO entradaBlogResponseDTO = entBlogService.getEntradaBlogById(id);
        if (entradaBlogResponseDTO == null) {
            throw new NotFoundException("El blog no fue encontrado");
        }
        return new ResponseEntity<>(entradaBlogResponseDTO, HttpStatusCode.valueOf(200));

    }
}
