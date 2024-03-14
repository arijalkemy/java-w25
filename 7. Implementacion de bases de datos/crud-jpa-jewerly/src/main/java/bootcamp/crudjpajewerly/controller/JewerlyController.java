package bootcamp.crudjpajewerly.controller;

import bootcamp.crudjpajewerly.dto.request.JewerlyRequest;
import bootcamp.crudjpajewerly.model.Jewerly;
import bootcamp.crudjpajewerly.service.IJewerlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewerlyController {

    private IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createjewerly(@RequestBody JewerlyRequest request) {
        jewerlyService.saveJewerly(request);
        return ResponseEntity.ok("La joya fue agregada correctamente");
    }

    @GetMapping("/jewerlys")
    public ResponseEntity<List<Jewerly>> getjewerlys() {
        return ResponseEntity.ok(jewerlyService.findJewerlys());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<String> editjewerly(@PathVariable long id, @RequestBody JewerlyRequest request) {
        jewerlyService.updateJewerly(id, request);
        return ResponseEntity.ok("La joya fue editada correctamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletejewerly (@PathVariable long id) {
        jewerlyService.deleteJewerly(id);
        return ResponseEntity.ok("La joya fue borrada correctamente");
    }

}
