package org.example.linktracker.controller;

import org.example.linktracker.dto.LinkDto;
import org.example.linktracker.dto.request.LinkDtoRequest;
import org.example.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController

public class LinkController {

    ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkDtoRequest link){
        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable long linkId, @RequestParam String password){
        LinkDto link = linkService.redirect(linkId, password);
        return new RedirectView(link.link());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> linkMetrics(@PathVariable long linkId){
        return new ResponseEntity<>(linkService.getLinkMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable long linkId){
        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.OK);
    }


 }
