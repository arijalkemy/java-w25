package com.linktraker.ejercicio2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.linktraker.ejercicio2.dto.LinkIdDto;
import com.linktraker.ejercicio2.dto.LinkUrlDto;
import com.linktraker.ejercicio2.service.LinkService;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/link")
    @ResponseBody
    public ResponseEntity<LinkIdDto> postEntradaBlog(@RequestBody LinkUrlDto linkUrlDto) {
        return new ResponseEntity<>(linkService.postLink(linkUrlDto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/validate/{id}")
    @ResponseBody
    public ResponseEntity<LinkIdDto> putLink(@PathVariable Integer id) {
        return new ResponseEntity<>(linkService.putLink(id), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/links")
    public ResponseEntity<?> getLinks() {
        return new ResponseEntity<>(linkService.getLinks(), HttpStatus.OK);
    }
}
