package com.lh.bootjavaspring_profiles_vivo_p2.controller;

import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkAuthDTO;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPost;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPostInvalidate;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.response.LinkDTOGetStats;
import com.lh.bootjavaspring_profiles_vivo_p2.service.LinkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    //SALA 9

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    /*@PostMapping("/invalidate/{linkId}") // deberia ser un put
    public void invalidateLink(@PathVariable String linkId) {
        linkService.postInvalidate(new LinkDTOPostInvalidate(Long.valueOf(linkId)));
    }*/
    @PostMapping("/invalidate/{linkId}") // deberia ser un put
    public ResponseEntity<?> invalidateLink(@PathVariable String linkId) {
        LinkDTOGetStats linkDTOGetStats = linkService.postInvalidate(new LinkDTOPostInvalidate(Long.valueOf(linkId)));
        return new ResponseEntity<>(linkDTOGetStats, HttpStatus.CREATED);
    }

    @PostMapping("/createLink") // ok
    public ResponseEntity<?> createLink(@RequestBody LinkDTOPost linkDto) {
        LinkDTOGetStats linkDTOGetStats = linkService.post(linkDto);
        return new ResponseEntity<>(linkDTOGetStats, HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<?> redirect(@PathVariable Long id, @RequestParam("password") String password) {
        LinkAuthDTO linkAuthDTO = new LinkAuthDTO(id, password);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", this.linkService.getLinkRedirect(linkAuthDTO).getUrl());
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
        //return "redirect:"+this.linkService.getLinkRedirect(linkAuthDTO).getUrl();
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> metrics(@PathVariable long id) {
        LinkDTOGetStats linkDTOGetStats = linkService.getStatsLink(id);
        return new ResponseEntity<>(linkDTOGetStats, HttpStatus.CREATED);
    }
}
