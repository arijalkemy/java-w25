package com.spring.LinkTracker.controller;

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

import com.spring.LinkTracker.dto.LinkDto;
import com.spring.LinkTracker.dto.LinkIdDto;
import com.spring.LinkTracker.dto.LinkRedirectsDto;
import com.spring.LinkTracker.dto.LinkUrlDto;
import com.spring.LinkTracker.dto.req.LinkReqDto;
import com.spring.LinkTracker.service.LinkService;

import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    LinkService linkService;

    // 1
    @PostMapping("/link")
    @ResponseBody
    public ResponseEntity<LinkIdDto> postEntradaBlog(@RequestBody LinkUrlDto linkUrlDto) {
        return new ResponseEntity<>(linkService.postLink(linkUrlDto), HttpStatusCode.valueOf(201));
    }

    // 2
    @GetMapping("/link/{linkId}")
    @ResponseBody
    public RedirectView redirectLink(@PathVariable LinkReqDto linkId) {
        RedirectView redirectView = new RedirectView();
        LinkDto linkDto = linkService.redirectLink(linkId);
        if (linkDto != null) {
            redirectView.setUrl(linkDto.getUrl());
        } else {
            redirectView.setUrl("https://www.mercadolibre.com.ar/");
        }
        return redirectView;

    }

    // 3
    @GetMapping("/metrics/{id}")
    @ResponseBody
    public ResponseEntity<LinkRedirectsDto> getMetrics(@PathVariable LinkReqDto id) {
        return new ResponseEntity<>(linkService.getMetrics(id), HttpStatusCode.valueOf(200));
    }

    // 4
    @GetMapping("/invalidate/{id}")
    @ResponseBody
    public ResponseEntity<LinkIdDto> putLink(@PathVariable LinkReqDto id) {
        return new ResponseEntity<>(linkService.putLink(id.getId()), HttpStatusCode.valueOf(200));
    }

    // aux
    @GetMapping("/links")
    public ResponseEntity<?> getLinks() {
        return new ResponseEntity<>(linkService.getLinks(), HttpStatus.OK);
    }
}
