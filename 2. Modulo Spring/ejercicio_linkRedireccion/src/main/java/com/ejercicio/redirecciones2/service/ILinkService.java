package com.ejercicio.redirecciones2.service;

import com.ejercicio.redirecciones2.dto.LinkDTO;
import com.ejercicio.redirecciones2.dto.MetricDTO;

public interface ILinkService {
    LinkDTO createLink(LinkDTO linkDTO);
    LinkDTO findLinkById(Integer id);
    boolean invalidateLink(Integer id);
    LinkDTO redirect(Integer id);

    MetricDTO getLinkCounter(Integer id);
}
