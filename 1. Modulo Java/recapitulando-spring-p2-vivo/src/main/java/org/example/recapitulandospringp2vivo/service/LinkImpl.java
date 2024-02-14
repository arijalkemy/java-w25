package org.example.recapitulandospringp2vivo.service;

import org.example.recapitulandospringp2vivo.dto.LinkDTO;
import org.example.recapitulandospringp2vivo.exceptions.NotFoundException;
import org.example.recapitulandospringp2vivo.exceptions.PermissionDenied;
import org.example.recapitulandospringp2vivo.models.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;
import static org.example.recapitulandospringp2vivo.repository.LinkRepository.linksStorage;

public class LinkImpl implements LinkInterface{
    @Override
    public LinkDTO crearLink(String id, String link) {
        linksStorage.put(id, new Link(link, "password"+id, 0,true));
        return new LinkDTO(id, linksStorage.get(id).getPass());
    }

    @Override
    public void invalidarLink(String id) throws NotFoundException {
        if (linksStorage.get(id) == null) throw new NotFoundException("No se encontró en link de acceso");
        linksStorage.get(id).setValid(false);
    }

    @Override
    public RedirectView validarRedirreccion(String id, String pass) throws PermissionDenied, NotFoundException{
        if (linksStorage.get(id) == null) throw new NotFoundException("No se encontró en link de acceso");
        if(!linksStorage.get(id).getValid())throw new PermissionDenied("Acceso denegado: link sin permisos");
        if(!Objects.equals(linksStorage.get(id).getPass(), pass))throw new PermissionDenied("Acceso denegado: clave erronea");
        linksStorage.get(id).setRedirections(linksStorage.get(id).getRedirections()+1);
        return new RedirectView("https://google.com");
    }

    @Override
    public int conocerCantidadDeRedirecciones(String id) throws NotFoundException {
        if (linksStorage.get(id) == null) throw new NotFoundException("No se encontró en link de acceso");
        return linksStorage.get(id).getRedirections();
    }
}
