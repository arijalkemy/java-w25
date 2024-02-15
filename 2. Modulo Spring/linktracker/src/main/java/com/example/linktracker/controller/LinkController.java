package com.example.linktracker.controller;

import com.example.linktracker.dto.request.LinkIdMetricsDTO;
import com.example.linktracker.dto.request.LinkRequestDTO;
import com.example.linktracker.dto.request.LinkRequestWithPassword;
import com.example.linktracker.dto.response.LinkIdResponseDTO;
import com.example.linktracker.dto.response.LinkMetricsDTO;
import com.example.linktracker.dto.response.ResponseDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.service.ILinkService;
import com.example.linktracker.service.LinkServiceImpl;
import com.example.linktracker.utils.RedirectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.URI;

@RestController
public class LinkController {
    ILinkService linkService;

    @Autowired
    public LinkController(LinkServiceImpl service) {
        this.linkService = service;
    }

    /*
     * 2. Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un
     * redirect a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link
     * sea invalido devolver 404(INVESTIGAR REDIRECT).
     * */
    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable int linkId,@RequestParam(required = false) String password){
        var header = new HttpHeaders();
        header.setLocation(URI.create(this.linkService.redirect(RedirectMapper
                .toRedirectRequestDTO(linkId,password)).getUrl()));
        return new ResponseEntity<>(header, HttpStatus.MOVED_PERMANENTLY);
    }

    /*
    4 Invalidate link: Endpoint POST para invalidar un link
    (ej: http://localhost:8080/invalidate/{linkID} ).
     */
    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<ResponseDTO> invalidateLink(@PathVariable Integer linkID){
        return ResponseEntity.ok(this.linkService.invalidateLink(linkID))  ;

    }
    /*
    * 1. Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que
    * devolver un JSON con el linkId para utilizar en la redirección.
    * */
    @PostMapping("/newLink")
    public ResponseEntity<LinkIdResponseDTO> newLink(@RequestBody LinkRequestDTO newLink, @RequestParam(required = false) String password) {
        LinkIdResponseDTO res = linkService.createLink(new LinkRequestWithPassword(newLink.getUrl(), password));
        return ResponseEntity.ok(res);
    }

    /*
       3. Estadísticas por link: Endpoint GET que dado un link
        (ej: http://localhost:8080/metrics/{linkID} ) tiene que devolver la estadística de cantidad
        de veces que se redireccionó.
    */
    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<LinkMetricsDTO> getMetrica(@PathVariable int linkID){
        return  ResponseEntity.ok(this.linkService.getMetrics(new LinkIdMetricsDTO(linkID)));
    }


}
