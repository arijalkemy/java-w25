package it.bootcamp.proyectolinktracker.controller;

import it.bootcamp.proyectolinktracker.dto.request.LinkMetricsResponseDTO;
import it.bootcamp.proyectolinktracker.dto.request.LinkRequestDTO;
import it.bootcamp.proyectolinktracker.dto.response.LinkResponseDTO;
import it.bootcamp.proyectolinktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestParam String url, @RequestParam String password){
        return ResponseEntity.ok().body(linkService.create(new LinkRequestDTO(url,password)));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectLink(@PathVariable Integer linkId, @RequestParam String password){
        return new RedirectView(linkService.redirect(linkId, password));
    }
    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsResponseDTO> getMetrics(@PathVariable Integer linkId){
        return ResponseEntity.ok().body(linkService.getMetrics(linkId));
    }
    @PostMapping("/invalidate/{linkId}/{password}")
    public void invalidateLink(@PathVariable Integer linkId, @PathVariable String password){
        linkService.invalidate(linkId, password);
    }
}
