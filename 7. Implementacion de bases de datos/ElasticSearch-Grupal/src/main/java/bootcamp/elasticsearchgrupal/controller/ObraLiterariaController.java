package bootcamp.elasticsearchgrupal.controller;

import bootcamp.elasticsearchgrupal.dto.request.ObraLiterariaRequestDTO;
import bootcamp.elasticsearchgrupal.dto.response.ObraLiterariaResponseDTO;
import bootcamp.elasticsearchgrupal.service.IObraLiterariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obras")
public class ObraLiterariaController {

    private final IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping
    public ResponseEntity<String> createObraLiteraria(@RequestBody ObraLiterariaRequestDTO request) {
        obraLiterariaService.createObraLiteraria(request);
        return ResponseEntity.ok("Obra literaria creada exitósamente.");
    }

    @GetMapping
    public ResponseEntity<List<ObraLiterariaResponseDTO>> getAllObrasLiterarias() {
        return ResponseEntity.ok(obraLiterariaService.getAllObrasliterarias());
    }

    @GetMapping("/nombre/{word}")
    public ResponseEntity<List<ObraLiterariaResponseDTO>> getObraLiteraria(@PathVariable String word) {
    //@GetMapping("/nombre")
    //public ResponseEntity<List<ObraLiterariaResponseDTO>> getObraLiteraria(@RequestParam String word) {
        return ResponseEntity.ok(obraLiterariaService.getObraLiteraria(word));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaResponseDTO>> getObrasLiterariasOfAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterariasOfAutor(autor));
    }

    @GetMapping("/top5")
    public ResponseEntity<List<ObraLiterariaResponseDTO>> getObrasLiterariasTop5OrderedByCantidadDepaginasDesc() {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterariasTop5OrderedByCantidadDepaginasDesc());
    }

    @GetMapping("before-year/{year}")
    public ResponseEntity<List<ObraLiterariaResponseDTO>> getObrasLiterariasBeforeYear(@PathVariable Integer year) {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterariasBeforeYear(year));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaResponseDTO>> getObrasLiterariasOfEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterariasOfEditorial(editorial));
    }

}
