package com.ejercicio.redirecciones.service;

import com.ejercicio.redirecciones.dto.LinkDTO;
import com.ejercicio.redirecciones.dto.MetricDTO;

public interface ILinkService {
    LinkDTO createLink(LinkDTO linkDTO);
    LinkDTO findLinkById(Integer id);
    boolean invalidateLink(Integer id);
    LinkDTO redirect(Integer id);

    MetricDTO getLinkCounter(Integer id);
}
