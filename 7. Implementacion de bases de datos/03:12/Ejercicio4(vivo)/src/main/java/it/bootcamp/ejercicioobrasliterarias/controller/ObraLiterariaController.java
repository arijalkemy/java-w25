package it.bootcamp.ejercicioobrasliterarias.controller;

import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaReqDTO;
import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaResDTO;
import it.bootcamp.ejercicioobrasliterarias.service.ObraLiterariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraLiterariaController {

    @Autowired
    private final ObraLiterariaService obraService;

    public ObraLiterariaController(ObraLiterariaService obraService) {
        this.obraService = obraService;
    }

    @PostMapping("/new-obra")
    public ResponseEntity<?> saveObra(@RequestBody ObraLiterariaReqDTO nuevaObra) {
        return ResponseEntity.ok(obraService.saveObra(nuevaObra));
    }

    @GetMapping("")
    public ResponseEntity<List<ObraLiterariaResDTO>> getAllObras() {
        return ResponseEntity.ok(obraService.getAllObras());
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaResDTO>> getObrasByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraService.getObrasByAutor(autor));
    }

    @GetMapping("/keyword/{word}")
    public ResponseEntity<List<ObraLiterariaResDTO>> getObrasLikeNombre(@PathVariable String word) {
        return ResponseEntity.ok(obraService.getObrasLikeNombre(word));
    }

    @GetMapping("/obras-top-paginas")
    public ResponseEntity<List<ObraLiterariaResDTO>> getObrasTop5Paginas() {
        return ResponseEntity.ok(obraService.getObrasTop5Paginas());
    }

    @GetMapping("/before-year/{year}")
    public ResponseEntity<List<ObraLiterariaResDTO>> getObrasReleasedBeforeAnio(@PathVariable Integer year) {
        return ResponseEntity.ok(obraService.getObrasReleasedBeforeAnio(year));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaResDTO>> getObrasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraService.getObrasByEditorial(editorial));
    }

}
