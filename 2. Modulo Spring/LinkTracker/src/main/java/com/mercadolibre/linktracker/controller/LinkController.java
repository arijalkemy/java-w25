package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkIdDTO;
import com.mercadolibre.linktracker.dto.MessageDTO;
import com.mercadolibre.linktracker.dto.MetricDTO;
import com.mercadolibre.linktracker.service.ILinkService;
import com.mercadolibre.linktracker.service.LinkServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    ILinkService linkService;

    public LinkController(LinkServiceImp linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkIdDTO> createLink(@RequestBody LinkDTO linkDTO) {
        return new ResponseEntity<>(linkService.addLink(linkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Void> redirectToLink(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(linkService.redirectToLink(id).getUrl()))
                .build();
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricDTO> getLinkVisitCounter(@PathVariable Integer id) {
        return new ResponseEntity<>(linkService.getLinkVisitCounter(id), HttpStatus.OK);
    }

    @PatchMapping("/link/{id}")
    public ResponseEntity<MessageDTO> invalidateLink(@PathVariable Integer id) {
        linkService.invalidateLink(id);
        return new ResponseEntity<>(new MessageDTO("Link invalidado."), HttpStatus.OK);
    }
}
