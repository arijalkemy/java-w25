package com.spring.linktracker.controller;

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

import com.spring.linktracker.dto.LinkIdDto;
import com.spring.linktracker.dto.LinkRedirectsDto;
import com.spring.linktracker.dto.LinkUrlDto;
import com.spring.linktracker.dto.req.LinkReqDto;
import com.spring.linktracker.service.LinkService;

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

    @GetMapping("/metrics/{id}")
    @ResponseBody
    public ResponseEntity<LinkRedirectsDto> getMetrics(@PathVariable LinkReqDto id) {
        return new ResponseEntity<>(linkService.getMetrics(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/links")
    public ResponseEntity<?> getLinks() {
        return new ResponseEntity<>(linkService.getLinks(), HttpStatus.OK);
    }
}
