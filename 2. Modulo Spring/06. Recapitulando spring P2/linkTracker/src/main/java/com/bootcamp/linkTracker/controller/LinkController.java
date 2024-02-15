package com.bootcamp.linkTracker.controller;

import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.response.LinkResponseDTO;
import com.bootcamp.linkTracker.dto.response.ResponseDTO;
import com.bootcamp.linkTracker.dto.response.StatisticsDTO;
import com.bootcamp.linkTracker.service.ILinkService;
import com.bootcamp.linkTracker.service.LinkServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final ILinkService iLinkService;

    @Autowired
    public  LinkController(LinkServiceImp linkServiceImp) {
        this.iLinkService = linkServiceImp;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createLink(
            @RequestBody LinkDTO linkDTO
    ) {
        return new ResponseEntity<>(iLinkService.createLink(linkDTO), HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkId}")
    public RedirectView redirectLink(
            @PathVariable long linkId ,@RequestParam String password){
        LinkResponseDTO linkResponseDTO = iLinkService.redirectLink(linkId, password);
        return new RedirectView(linkResponseDTO.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<StatisticsDTO> getMetrics(
            @PathVariable long linkId){
        return ResponseEntity.ok(iLinkService.getStatistics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(
            @PathVariable long linkId){
        iLinkService.invalidateLink(linkId);
        return new ResponseEntity<>("Link con id " + linkId + " ha sido invalidado.", HttpStatus.OK);
    }
}
