package com.example.blog.controller;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.dto.IdDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private HashMap<Integer, EntradaBlogDTO> entradas = new HashMap<>();

    @PostMapping
    public ResponseEntity<?> verificarExistId(@RequestBody EntradaBlogDTO entrada){
        if (entradas.containsKey(entrada.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe una entrada de blog con ese ID.");
        }
        entrada.setFechaPublicacion(String.valueOf(LocalDate.now()));
        entradas.put(entrada.getId(), entrada);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entrada de blog creada con exito. ID: " + entrada.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> informacionDeUnBlog(@PathVariable Integer id){
        if (!entradas.containsKey(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro una entrada de blog con ese ID.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entradas.get(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> todasLasEntradas(){
        return ResponseEntity.status(HttpStatus.OK).body(entradas);
    }
}
