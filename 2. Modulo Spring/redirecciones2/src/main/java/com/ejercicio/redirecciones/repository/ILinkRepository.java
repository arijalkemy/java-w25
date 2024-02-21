package com.ejercicio.redirecciones.repository;

import com.ejercicio.redirecciones.entity.Link;

public interface ILinkRepository {
    Link addLink(Link link);

    Link findLinkById(Integer id);

    Boolean invalidateLink(Integer id);
}
