package com.example.showroom.controller;

import com.example.showroom.dto.request.ClotheReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;
import com.example.showroom.service.ClothesServiceImpl;
import com.example.showroom.service.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private IClothesService clothesService;

    public ClothesController(ClothesServiceImpl clothesService){
        this.clothesService = clothesService;
    }

    //Crear una nueva prenda.
    @PostMapping("")
    public ResponseEntity<ConfirmationMessage> saveClothes(@RequestBody ClotheReqDto clothesDTO){
        return new ResponseEntity<>(clothesService.saveNewClothes(clothesDTO), HttpStatus.CREATED);
    }

    //Devolver todas las prendas
    @GetMapping("")
    public ResponseEntity<List<ClotheDto>> getAllClothes(){
        return new ResponseEntity<>(clothesService.getAllClothes(), HttpStatus.OK);
    }

    //Devolver una prenda en particular
    @GetMapping("/ByCode/{code}")
    public ResponseEntity<ClotheDto> getClotheByCode(@PathVariable Long code){
        return new ResponseEntity<>(clothesService.getClotheByCode(code), HttpStatus.OK);
    }

    //Actualizar una prenda en particular
    @PutMapping("/{code}")
    public ResponseEntity<ConfirmationMessage> updateClothes(@RequestBody ClotheReqDto clothesDTO, @PathVariable Long code){
        return new ResponseEntity<>(clothesService.updateClothe(clothesDTO, code), HttpStatus.CREATED);
    }
    //Eliminar una prenda en particular
    @DeleteMapping("/{code}")
    public ResponseEntity<ConfirmationMessage> deleteClothes(@PathVariable Long code){
        return new ResponseEntity<>(clothesService.deleteClothesById(code), HttpStatus.ACCEPTED);
    }

    //Traer todas las prendas de un determinado talle
    @GetMapping("/BySize/{size}")
    public ResponseEntity<List<ClotheDto>> getClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(clothesService.getClothesBySize(size), HttpStatus.CREATED);
    }

    //Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas
    @GetMapping("/getByName")
    public ResponseEntity<List<ClotheDto>> getClothesByName(@RequestParam("name") String name){
     return new ResponseEntity<>(clothesService.getClothesByName(name), HttpStatus.CREATED);
    }

}
