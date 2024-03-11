package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.MessageDTO;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    private final IJoyaService joyaServ;

    JoyaController (IJoyaService joyaServ) {
        this.joyaServ = joyaServ;
    }

    @PostMapping ("/jewerly/new")
    public ResponseEntity<MessageDTO> saveJoya (
        @RequestBody Joya joya
    ) {
        return new ResponseEntity<>(joyaServ.saveJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping ("/jewerly")
    public ResponseEntity<List<Joya>> getJoyas () {

        return new ResponseEntity<>(joyaServ.getJoyas(), HttpStatus.OK);
    }

    //como es un borrado lógico, se trata más bien de un update y no de un delete
    //por eso usamos put
    @PutMapping ("/jewerly/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJoya (@PathVariable Long id) {

        return new ResponseEntity<>(joyaServ.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<MessageDTO> editJoya (
        @PathVariable Long id_modificar,
        @RequestBody Joya joya
    ) {
        return new ResponseEntity<>(joyaServ.editJoya(id_modificar, joya), HttpStatus.OK);
    }


}
