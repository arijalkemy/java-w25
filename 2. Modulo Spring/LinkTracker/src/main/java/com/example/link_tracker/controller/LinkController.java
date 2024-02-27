package com.example.link_tracker.controller;

import com.example.link_tracker.service.ILinkServices;
import com.example.link_tracker.service.LinkServicesImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    ILinkServices linkServices;

    public LinkController(LinkServicesImp linkServices) {
        this.linkServices = linkServices;
    }

    @PostMapping("/{link}")
    public ResponseEntity<?> createLink(@RequestBody String link) {
        return ResponseEntity.ok(linkServices.createLink(link));
    }
}
