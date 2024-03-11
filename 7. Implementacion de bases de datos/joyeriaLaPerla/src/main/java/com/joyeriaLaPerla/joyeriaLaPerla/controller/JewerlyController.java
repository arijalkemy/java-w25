package com.joyeriaLaPerla.joyeriaLaPerla.controller;

import com.joyeriaLaPerla.joyeriaLaPerla.dto.JewerlyDTO;
import com.joyeriaLaPerla.joyeriaLaPerla.model.Jewerly;
import com.joyeriaLaPerla.joyeriaLaPerla.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/jewerly")
public class JewerlyController {
    @Autowired
    private IJewerlyService jwService;

    @PostMapping("/new")
    public ResponseEntity<?> createJewerly(@RequestBody JewerlyDTO jewerly){
        return new ResponseEntity<>(jwService.saveJewerly(jewerly),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllJewerly(){
        return new ResponseEntity<>(jwService.getAllJewerly(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id){
        return new ResponseEntity<>(jwService.deleteJewerly(id),HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editJewerly(
            @PathVariable Long id,
            @RequestBody JewerlyDTO jewerly){
        return new ResponseEntity<>(jwService.editJewerly(id, jewerly),HttpStatus.OK);
    }
}
