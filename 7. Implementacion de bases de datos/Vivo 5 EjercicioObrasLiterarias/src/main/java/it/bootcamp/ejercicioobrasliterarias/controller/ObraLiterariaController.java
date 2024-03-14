package it.bootcamp.ejercicioobrasliterarias.controller;

import it.bootcamp.ejercicioobrasliterarias.dto.NewObraLiterariaDto;
import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaDto;
import it.bootcamp.ejercicioobrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraLiterariaController {

    @Autowired
    IObraLiterariaService obraService;

    @PostMapping("/newObra")
        public ResponseEntity<?> newObra(@RequestBody ObraLiterariaDto nuevaObra){
        return ResponseEntity.ok(obraService.saveObra(nuevaObra));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasByAutor(@PathVariable String autor){
        return ResponseEntity.ok(obraService.getObrasByAutor(autor));
    }

    @GetMapping("")
    public ResponseEntity<List<ObraLiterariaDto>> getAll(){
        return ResponseEntity.ok(obraService.getAllObras());
    }

    @GetMapping("/keyWord/{word}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasLikeNombre(@PathVariable String word){
        return ResponseEntity.ok(obraService.getObrasLikeNombre(word));
    }

    @GetMapping("/obrasTopPaginas")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasTop5Paginas(){
        return ResponseEntity.ok(obraService.getObrasTop5Paginas());
    }

    @GetMapping("/beforeYear/{year}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasBeforeYear(@PathVariable Integer year){
        return ResponseEntity.ok(obraService.getObrasReleasedBeforeAnio(year));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(obraService.getObrasByEditorial(editorial));
    }
}
