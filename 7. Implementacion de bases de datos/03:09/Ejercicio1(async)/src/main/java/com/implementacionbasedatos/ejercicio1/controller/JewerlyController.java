package com.implementacionbasedatos.ejercicio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.implementacionbasedatos.ejercicio1.dto.req.JewerlyReqDto;
import com.implementacionbasedatos.ejercicio1.dto.res.JewerlyResDto;
import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDto;
import com.implementacionbasedatos.ejercicio1.service.IJewerlyService;

@RestController
@RequestMapping("/jewelries")
public class JewerlyController {
    @Autowired
    private IJewerlyService iJewerlyService;

    @GetMapping("/getJewerly")
    public ResponseEntity<List<JewerlyResDto>> getJewerly() {
        List<JewerlyResDto> jewerlyList = iJewerlyService.getJewerly();
        return new ResponseEntity<>(jewerlyList, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/postJewerly")
    public ResponseEntity<MessageResDto> postJewerly(@RequestBody JewerlyReqDto jewerlyDto) {
        MessageResDto messageRes = iJewerlyService.postJewerly(jewerlyDto);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/deleteJewerly/{id}")
    public ResponseEntity<MessageResDto> deleteJewerly(@PathVariable long id) {
        MessageResDto messageRes = iJewerlyService.deleteJewerly(id);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(204));
    }

    @PutMapping("/putJewerly/{id}")
    public ResponseEntity<JewerlyResDto> putJewerly(@PathVariable long id,
            @RequestBody JewerlyReqDto jewerlyDto) {
        JewerlyResDto jewerlyRes = iJewerlyService.putJewerly(id, jewerlyDto);
        return new ResponseEntity<>(jewerlyRes, HttpStatusCode.valueOf(200));
    }

}
