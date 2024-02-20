package com.example.LinkTracker.controller;

import com.example.LinkTracker.dto.LinkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class LinkController {

    private HashMap<Integer, LinkDTO> links = new HashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger();

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestParam String originalUrl, @RequestParam(required = false) String password) {

        int linkId = idGenerator.incrementAndGet();
        LinkDTO link = new LinkDTO(linkId, originalUrl, password, 0);
        links.put(linkId, link);

        return ResponseEntity.ok(Map.of("linkId", linkId));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redireccionar(@PathVariable int linkId, @RequestBody(required = false) String password) {
        LinkDTO link = links.get(linkId);
        if (link == null || !Objects.equals(password, link.getPassword())) {
            return ResponseEntity.notFound().build();
        }

        link.setRedirectCount(link.getRedirectCount() + 1);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link.getOriginalUrl())).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> obtenerEstadisticas(@PathVariable int linkId) {
        LinkDTO link = links.get(linkId);
        if (link == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Map.of("redirectCount", link.getRedirectCount()));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidarLink(@PathVariable int linkId) {
        LinkDTO removedLink = links.remove(linkId);
        if (removedLink == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
