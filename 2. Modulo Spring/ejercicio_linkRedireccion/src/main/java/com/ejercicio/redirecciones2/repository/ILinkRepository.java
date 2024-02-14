package com.ejercicio.redirecciones2.repository;

import com.ejercicio.redirecciones2.entity.Link;

public interface ILinkRepository {
    Link addLink(Link link);

    Link findLinkById(Integer id);

    Boolean invalidateLink(Integer id);
}
