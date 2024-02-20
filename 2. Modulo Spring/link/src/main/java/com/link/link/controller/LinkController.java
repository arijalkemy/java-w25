package com.link.link.controller;

import com.link.link.dto.request.CreateLinkDTO;
import com.link.link.dto.response.CreatedLinkIdDTO;
import com.link.link.dto.response.LinkMetricsDTO;
import com.link.link.dto.response.RedirectLinkDTO;
import com.link.link.service.ILinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<CreatedLinkIdDTO> createLink(@RequestBody CreateLinkDTO link) {
        return ResponseEntity.ok(this.linkService.createLink(link));
    }

    @GetMapping("/link/{id}")
    public RedirectView redirectLinkById(@PathVariable int id, @RequestParam(required = false) String password) {
        return this.linkService.getLinkById(id, password).getRedirectView();
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkMetricsDTO> getLinkMetrics(@PathVariable int id) {
        return ResponseEntity.ok(this.linkService.getLinkMetrics(id));
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<CreatedLinkIdDTO> addInvalidLink(@PathVariable int id) {
        this.linkService.addInvalidLink(id);
        return ResponseEntity.ok(new CreatedLinkIdDTO(id));
    }
}
