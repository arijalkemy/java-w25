package com.linktracker.linktracker.controller;

import com.linktracker.linktracker.dto.request.LinkBodyDto;
import com.linktracker.linktracker.dto.response.EstadisticasDTO;
import com.linktracker.linktracker.dto.response.IdLinkDto;
import com.linktracker.linktracker.dto.response.RedirectDTO;
import com.linktracker.linktracker.entity.Link;
import com.linktracker.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @PostMapping("/link")
    public ResponseEntity<IdLinkDto> createLink(@RequestParam("password") String password,
                                                @RequestBody LinkBodyDto link){
        /*
        Crear un link: Endpoint POST para crear link a partir de una URL válida
         y tiene que devolver un JSON con el linkId para utilizar en la redirección
         Al crear los links se tiene que poder agregar un password que va a ser un query param
         al llamar a la redirección.

         */


        return ResponseEntity.ok().body(service.crearLink(link.uri(), password));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirectLink(@PathVariable("linkId") int linkId,
                                          @RequestParam("password") String password){
        /*
        Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} )
         tiene que realizar un redirect a la URL enmascarada.
         Siempre y cuando el link sea válido. En el caso de que el link
         sea invalido devolver 404(INVESTIGAR REDIRECT).
         Al crear los links se tiene que poder agregar un password que va a ser un query param
         al llamar a la redirección.

        STACK OVERFLOW SOBRE REDIRECCION
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("https://www.google.com"));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
         */
        RedirectDTO redirectDTO = this.service.redireccion(linkId,password);
        if(redirectDTO != null){
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(redirectDTO.getUri()));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        }

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metricsLink(@PathVariable("linkId") int linkId){
        /*
        Estadísticas por link: Endpoint GET que dado un link
        (ej: http://localhost:8080/metrics/{linkID} ) tiene que devolver
        la estadística de cantidad de veces que se redireccionó.
         */

        EstadisticasDTO estadisticasDTO = this.service.getById(linkId);
        return  ResponseEntity.ok().body(estadisticasDTO);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Link> invalidateLink(@PathVariable("linkId") int linkId){
        /*
        Invalidate link: Endpoint POST para invalidar un link
        (ej: http://localhost:8080/invalidate/{linkID} ).
         */
        Link link = this.service.invalidar(linkId);
        if(link != null) return ResponseEntity.ok().body(link);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
