package com.bootcamp.linkTracker.controller;

import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.response.LinkResponseDTO;
import com.bootcamp.linkTracker.dto.response.ResponseDTO;
import com.bootcamp.linkTracker.dto.response.StatisticsDTO;
import com.bootcamp.linkTracker.dto.response.SuccessCreateLinkDTO;
import com.bootcamp.linkTracker.service.ILinkService;
import com.bootcamp.linkTracker.service.impl.LinkServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.linkTracker.*;
import org.springframework.web.servlet.function.ServerRequest;

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
    public ResponseEntity<Void> getRedirectTimes(
            @PathVariable long linkId ,@RequestParam String password){
        HttpHeaders header = new HttpHeaders();
        header.add("Location",iLinkService.redirectLink(linkId).getUrl());
        return new ResponseEntity<>(header,HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<StatisticsDTO> getMetrics(
            @PathVariable long linkId){
        return ResponseEntity.ok(iLinkService.getStatistics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponseDTO> invalidateLink(
            @PathVariable long linkId){
        iLinkService.invalidateLink(linkId);
        return new ResponseEntity<>(new ResponseDTO(linkId),HttpStatus.OK);
    }


}
