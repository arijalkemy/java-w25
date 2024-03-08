package com.bootcamp.ejercicio_link_tracker.controller;

import com.bootcamp.ejercicio_link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.ejercicio_link_tracker.dto.request.LinkMetricsResponseDTO;
import com.bootcamp.ejercicio_link_tracker.dto.request.LinkRequestDTO;
import com.bootcamp.ejercicio_link_tracker.service.ILinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    private ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

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
