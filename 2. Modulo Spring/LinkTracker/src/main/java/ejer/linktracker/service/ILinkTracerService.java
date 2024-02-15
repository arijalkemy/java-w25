package ejer.linktracker.service;

import ejer.linktracker.DTO.request.LinkCreationDTO;
import ejer.linktracker.DTO.response.LinkDTO;
import ejer.linktracker.DTO.response.LinkEstadisticasDto;

import java.util.List;

public interface  ILinkTracerService {
    public void addLink(LinkCreationDTO linkCreationDTO);
    public LinkDTO getById(int id);
    public List<LinkDTO> getAll();
    public LinkEstadisticasDto getMetrics(int id);
    public void invalidateLink(int id);
    public String redirect(int id,String contrasena);
}
