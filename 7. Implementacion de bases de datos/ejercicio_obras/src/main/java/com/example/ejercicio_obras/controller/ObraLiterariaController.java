package com.example.ejercicio_obras.controller;

import com.example.ejercicio_obras.dto.ObraLiterariaDTO;
import com.example.ejercicio_obras.model.ObraLiteraria;
import com.example.ejercicio_obras.service.IObraLiterariaService;
import com.example.ejercicio_obras.service.ObraLiterariaServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obra")
public class ObraLiterariaController {

    private final IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(ObraLiterariaServiceImp obraLiterariaService){
        this.obraLiterariaService = obraLiterariaService;
    }

    /**
     * create a new obra literaria
     * @param ObraLiteriaDTO
     * @return new obra
     */
    @PostMapping("/new")
    public ResponseEntity<ObraLiterariaDTO>  createNewObra(@RequestBody ObraLiterariaDTO obra){
        return ResponseEntity.ok(obraLiterariaService.save(obra));
    }

    // Punto 1
    @GetMapping("/get/{autor}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObrasByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.getBookByAutor(autor));
    }

    //Punto 2
    @GetMapping("/titulo/{palabra}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObrasByTitle(@PathVariable String palabra){
        return ResponseEntity.ok(obraLiterariaService.listByKeyWords(palabra));
    }

    //Punto 3
    @GetMapping("/get/topObras")
    public ResponseEntity<List<ObraLiterariaDTO>> getTopFiveObras() {
        return ResponseEntity.ok(obraLiterariaService.listTopFive());
    }

    //Punto 4
    @GetMapping("/get/before/{anio}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObrasBeforeAnio(@PathVariable Integer anio) {
        return ResponseEntity.ok(obraLiterariaService.listBefore(anio));
    }

    //Punto 5
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.listByEditorial(editorial));
    }

}
