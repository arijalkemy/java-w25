package com.ejercicio.redirecciones.controller;


import com.ejercicio.redirecciones.dto.LinkDTO;
import com.ejercicio.redirecciones.dto.MetricDTO;
import com.ejercicio.redirecciones.dto.ResponseMessageDTO;
import com.ejercicio.redirecciones.service.ILinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


// Grupo 12
@AllArgsConstructor
@RestController
public class LinkController {

    public final ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDTO> addLink(@RequestBody LinkDTO linkDTO){
        return new ResponseEntity<>(linkService.createLink(linkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Void> linkRedirect(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(linkService.redirect(id).getUrl()))
                .build();
    }

    @PatchMapping("/link/{id}")
    public ResponseEntity<ResponseMessageDTO> linkInvalidation(@PathVariable Integer id){
        linkService.invalidateLink(id);
        return new ResponseEntity<>(new ResponseMessageDTO("Link invalidado"), HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricDTO> getLinkCounter(@PathVariable Integer id){
        return new ResponseEntity<>(linkService.getLinkCounter(id), HttpStatus.OK);

    }

}
