package org.example.recapitulandospringp2vivo.service;
import org.example.recapitulandospringp2vivo.dto.LinkDTO;
import org.example.recapitulandospringp2vivo.exceptions.NotFoundException;
import org.example.recapitulandospringp2vivo.exceptions.PermissionDenied;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

public interface LinkInterface {
    LinkDTO crearLink(String id, String link);
    void invalidarLink(String id) throws NotFoundException;
    RedirectView validarRedirreccion(String id, String pass) throws PermissionDenied, NotFoundException;

    int conocerCantidadDeRedirecciones(String id) throws NotFoundException;
}
