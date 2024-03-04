package it.bootcamp.proyectolinktracker.service;

import it.bootcamp.proyectolinktracker.dto.request.LinkMetricsResponseDTO;
import it.bootcamp.proyectolinktracker.dto.request.LinkRequestDTO;
import it.bootcamp.proyectolinktracker.dto.response.LinkRedirectDTO;
import it.bootcamp.proyectolinktracker.dto.response.LinkResponseDTO;
import it.bootcamp.proyectolinktracker.entity.Link;

public interface ILinkService {
    LinkResponseDTO create(LinkRequestDTO request);
    String redirect(Integer linkId, String password);
    LinkMetricsResponseDTO getMetrics(Integer linkId);
    void invalidate(Integer linkId, String password);
}
