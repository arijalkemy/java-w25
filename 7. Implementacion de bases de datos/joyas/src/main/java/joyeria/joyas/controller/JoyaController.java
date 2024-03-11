package joyeria.joyas.controller;

import joyeria.joyas.DTO.Response.JoyaDTO;
import joyeria.joyas.entity.Joya;
import joyeria.joyas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/jewerly")
public class JoyaController {

    private IJoyaService joyaService;
    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody JoyaDTO joya){
        return new ResponseEntity<> (joyaService.create(joya), HttpStatus.OK);
    }
}
