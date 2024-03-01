package org.example.recapitulandospringp2vivo.controller;
import org.example.recapitulandospringp2vivo.dto.LinkDTO;
import org.example.recapitulandospringp2vivo.exceptions.NotFoundException;
import org.example.recapitulandospringp2vivo.exceptions.PermissionDenied;
import org.example.recapitulandospringp2vivo.service.LinkImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class mainController {

    @PostMapping("/")
    public ResponseEntity<LinkDTO> crearLink(@RequestParam String id, @RequestParam String link){
        return new ResponseEntity<>(new LinkImpl().crearLink(id,link), HttpStatus.OK);
    }
    @GetMapping("/link/{linkId}")
    public RedirectView redireccionarLink(@PathVariable String linkId, @RequestParam String pass) throws PermissionDenied, NotFoundException{
        return new LinkImpl().validarRedirreccion(linkId, pass);
    }

    @PostMapping("/invalidate")
    public ResponseEntity<?> invalidateLink(@RequestParam String id) throws NotFoundException {
        new LinkImpl().invalidarLink(id);
        return new ResponseEntity<>("Acceso denegado a link: "+id, HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> redireccionesPorLink(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(new LinkImpl().conocerCantidadDeRedirecciones(id),HttpStatus.OK);
    }
}
