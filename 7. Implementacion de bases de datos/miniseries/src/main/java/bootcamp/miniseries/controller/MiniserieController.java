package bootcamp.miniseries.controller;

import bootcamp.miniseries.dto.request.MiniSerieRequestDTO;
import bootcamp.miniseries.dto.response.AwardsOfMiniserieResponseDTO;
import bootcamp.miniseries.dto.response.MiniSerieResponseDTO;
import bootcamp.miniseries.service.IMiniserieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/miniseries")
public class MiniserieController {

    @Autowired
    private IMiniserieService miniserieService;

    @GetMapping
    public ResponseEntity<List<MiniSerieResponseDTO>> getAllMiniseries() {
        return ResponseEntity.ok(miniserieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniSerieResponseDTO> getOneMiniserie(@PathVariable("id") Long id) {
        return ResponseEntity.ok(miniserieService.findOne(id));
    }


    @PostMapping
    public ResponseEntity<?> createMiniSerie( @RequestBody MiniSerieRequestDTO miniseerie){
        miniserieService.save(miniseerie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/awards")
    public ResponseEntity<AwardsOfMiniserieResponseDTO> getAwardsOfMiniserie(@PathVariable Long id) {
        return ResponseEntity.ok(miniserieService.getAwardsOfMiniserie(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<MiniSerieResponseDTO> getOneMiniserie(@PathVariable("name") String name) {
        return ResponseEntity.ok(miniserieService.getByName(name));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        miniserieService.deleteById(id);
    }

}
