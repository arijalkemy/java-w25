package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.InfoDto;
import com.mercadolibre.linktracker.dto.LinkDto;
import com.mercadolibre.linktracker.dto.LinkStadisticDto;
import com.mercadolibre.linktracker.dto.MaskLinkDto;
import com.mercadolibre.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class LinkController {

    LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<MaskLinkDto> add(@RequestBody LinkDto linkDto){
        return new ResponseEntity<>(this.linkService.add(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable Integer id , @RequestParam String password){
        LinkDto redirectLink = this.linkService.getById(id, password);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectLink.getLink());
        return redirectView;
    }

    @GetMapping("/link/metrics/{id}")
    public ResponseEntity<LinkStadisticDto> metric(@PathVariable Integer id){
        return new ResponseEntity<>(this.linkService.getStadistic(id),HttpStatus.OK);
    }

    @PostMapping("/link/invalidate/{id}")
    public ResponseEntity<InfoDto> add(@PathVariable Integer id){
        this.linkService.disable(id);
        return new ResponseEntity<>(new InfoDto("link disabled","Link wiht id "+id +" is now invalid"), HttpStatus.GONE);
    }
}
