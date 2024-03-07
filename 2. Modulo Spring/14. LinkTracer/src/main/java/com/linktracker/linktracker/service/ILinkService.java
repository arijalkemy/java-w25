package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.response.IdLinkDto;
import com.linktracker.linktracker.dto.response.EstadisticasDTO;
import com.linktracker.linktracker.dto.response.RedirectDTO;
import com.linktracker.linktracker.entity.Link;

public interface ILinkService {

    IdLinkDto crearLink(String uri, String password);

    RedirectDTO redireccion(int id, String password);

    EstadisticasDTO getById(int id);

    Link invalidar(int id);
}
