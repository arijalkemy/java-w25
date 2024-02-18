package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkIdDTO;
import com.mercadolibre.linktracker.dto.MetricDTO;

import java.util.List;

public interface ILinkService {
    List<LinkDTO> getAllLinks();
    LinkDTO getLinkById(Integer id);
    LinkIdDTO addLink(LinkDTO link);
    LinkDTO redirectToLink(Integer id);
    MetricDTO getLinkVisitCounter(Integer id);
    void invalidateLink(Integer id);
}
