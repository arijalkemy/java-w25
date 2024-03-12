package com.joyeria.Joyeria.controller;

import com.joyeria.Joyeria.dto.JoyaRequestDTO;
import com.joyeria.Joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    private JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaRequestDTO joya) {
        return new ResponseEntity<>(joyaService.createJoya(joya), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllJoyas() {
        return new ResponseEntity<>(joyaService.getAllJoyas(), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar,
                                        @RequestBody JoyaRequestDTO joyaDto) {

        return new ResponseEntity<>(joyaService.updateJoya(id_modificar, joyaDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.deleteJoya(id), HttpStatus.OK);
    }
}
