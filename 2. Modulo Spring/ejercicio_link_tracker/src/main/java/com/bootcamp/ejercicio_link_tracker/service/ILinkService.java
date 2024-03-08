package com.bootcamp.ejercicio_link_tracker.service;

import com.bootcamp.ejercicio_link_tracker.dto.request.LinkMetricsResponseDTO;
import com.bootcamp.ejercicio_link_tracker.dto.request.LinkRequestDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkResponseDTO;

public interface ILinkService {
    LinkResponseDTO create(LinkRequestDTO request);
    String redirect(Integer linkId, String password);
    LinkMetricsResponseDTO getMetrics(Integer linkId);
    void invalidate(Integer linkId, String password);
}