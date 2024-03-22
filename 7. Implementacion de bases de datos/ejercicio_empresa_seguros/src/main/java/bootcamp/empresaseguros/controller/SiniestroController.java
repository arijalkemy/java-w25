package bootcamp.empresaseguros.controller;

import bootcamp.empresaseguros.dto.request.SiniestroRequestDTO;
import bootcamp.empresaseguros.dto.response.SiniestroDTO;
import bootcamp.empresaseguros.dto.response.SucessDTO;
import bootcamp.empresaseguros.dto.response.VehiculoSiniestroDTO;
import bootcamp.empresaseguros.service.ISiniestroService;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {
    
    @Autowired
    private ISiniestroService siniestroService;

    @GetMapping("")
    public ResponseEntity<List<SiniestroDTO>> getAllSinister() {
        return ResponseEntity.ok(siniestroService.getSiniestros());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNewSinister (@RequestBody SiniestroRequestDTO request) {
        siniestroService.createSiniestro(request);
        return ResponseEntity.ok("Siniestro creado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiniestroDTO> getSinisterById(@PathVariable Long id) {
        return  ResponseEntity.ok(siniestroService.findSiniestro(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SucessDTO> deleteSinisterById (Long id) {
        return new ResponseEntity<>(siniestroService.deleteSiniestro(id), HttpStatus.OK);
    }

    @GetMapping("/lost")
    public ResponseEntity<?> findBySinisterLost() {
        return ResponseEntity.ok(siniestroService.findByPerdida());
    }

    @GetMapping("/lost/total")
    public ResponseEntity<?> getSinisterByEconomicalLostAndTotalSum() {
        return ResponseEntity.ok(siniestroService.findByPerdidaAndTotalSum());
    }

}
