package com.sfritz.linktracker.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.sfritz.linktracker.dtos.LinkRequestDto;
import com.sfritz.linktracker.dtos.LinkResponseDto;
import com.sfritz.linktracker.services.ILinkService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class LinkController {

    private ILinkService service;

    public LinkController(ILinkService service){
        this.service=service;
    }

    @PostMapping("/")
    public ResponseEntity<LinkResponseDto> createLink(@RequestBody LinkRequestDto requestDto) {
        return new ResponseEntity<>(service.createLink(requestDto),HttpStatus.CREATED);
    }
    
    @GetMapping("/link/{linkId}")
    public RedirectView redireccionar(@PathVariable String linkId) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://google.com");
        return redirectView;
    }
    
}
