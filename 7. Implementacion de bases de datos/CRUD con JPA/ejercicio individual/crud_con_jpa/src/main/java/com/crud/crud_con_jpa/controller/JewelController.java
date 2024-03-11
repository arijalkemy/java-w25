package com.crud.crud_con_jpa.controller;

import com.crud.crud_con_jpa.models.Jewel;
import com.crud.crud_con_jpa.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelController {

    JewelService jewelService;

    public JewelController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @GetMapping("/jewelry")
    public List<Jewel> getAllJewels() {
        System.out.println("Le pego a endpoint");
        return jewelService.getAllJewels();
    }

    @PostMapping("/jewelry/new")
    public ResponseEntity<String> createJewel(@RequestBody Jewel jewel) {
        jewelService.saveJewel(jewel);
        return new ResponseEntity<String>("La joya fue agregada exitosamente",HttpStatus.OK);
    }

    @DeleteMapping("/jewelry/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable Long id) {
        jewelService.deleteJewel(id);
        return new ResponseEntity<String>("La joya fue borrada exitosamente",HttpStatus.OK);
    }

}
