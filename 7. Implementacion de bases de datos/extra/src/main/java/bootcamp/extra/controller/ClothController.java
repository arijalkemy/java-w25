package bootcamp.extra.controller;

import bootcamp.extra.dto.RequestClothDTO;
import bootcamp.extra.service.IClothService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

    private final IClothService prendaService;

    public ClothController(IClothService prendaService){
        this.prendaService = prendaService;
    }

    @PostMapping
    public ResponseEntity<?> createCloth(@RequestBody RequestClothDTO body){
        return new ResponseEntity<>(prendaService.createPrenda(body), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getClothes(@RequestParam(required = false) String name){
        return new ResponseEntity<>(prendaService.getPrendas(name), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<?> getClothByCode(@PathVariable("code") String code){
        return new ResponseEntity<>(prendaService.getPrendaByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateCloth(@PathVariable("code") String code, @RequestBody RequestClothDTO body){
        return new ResponseEntity<>(prendaService.updatePrenda(code, body), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCloth(@PathVariable("code") String code){
        return new ResponseEntity<>(prendaService.deletePrenda(code), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable("size") String size){
        return new ResponseEntity<>(prendaService.getPrendasBySize(size), HttpStatus.OK);
    }

}
