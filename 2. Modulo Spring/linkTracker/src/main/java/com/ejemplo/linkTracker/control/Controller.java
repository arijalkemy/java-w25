package com.ejemplo.linkTracker.control;

import com.ejemplo.linkTracker.dto.LinkResDTO;
import com.ejemplo.linkTracker.dto.LinkRqDTO;
import com.ejemplo.linkTracker.service.IService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    IService service;

    public Controller(IService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkResDTO> createLink(@RequestBody LinkRqDTO linkRqDTO){

        return new ResponseEntity<>(service.createLink(linkRqDTO), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkID}")
    public ResponseEntity<Void> getLink(@PathVariable Integer linkID, @RequestParam(name = "password") String password){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", service.getLink(linkID, password));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<LinkResDTO> getMetrics(@PathVariable Integer linkID){

        return new ResponseEntity<>(service.getMetrics(linkID), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkID}")
    public ResponseEntity<LinkResDTO> invalid(@PathVariable Integer linkID){

        return new ResponseEntity<>(service.invalidLink(linkID), HttpStatus.OK);
    }
}
