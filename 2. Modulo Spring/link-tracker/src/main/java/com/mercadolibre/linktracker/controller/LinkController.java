package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.request.LinkPostDto;
import com.mercadolibre.linktracker.dto.response.LinkResponseDto;
import com.mercadolibre.linktracker.dto.response.LinkMetricsResponseDto;
import com.mercadolibre.linktracker.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class LinkController {
    private final LinkService linkService;
    @PostMapping("/create")
    public ResponseEntity<LinkResponseDto> createLink(@RequestBody LinkPostDto linkPostDto) {
        return ResponseEntity.ok(linkService.createLink(linkPostDto));
    }
    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable Integer linkId,
                                           @RequestParam(name = "password") String password) {
        String url = linkService.getRedirectLinkUrl(linkId, password);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(url)).build();
    }
    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsResponseDto> getMetrics(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }
    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkResponseDto> invalidateLink(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.invalidateLink(linkId));
    }
}
