package com.example.linktracker.service;

import com.example.linktracker.dto.request.LinkIdMetricsDTO;
import com.example.linktracker.dto.request.LinkRequestDTO;
import com.example.linktracker.dto.request.LinkRequestWithPassword;
import com.example.linktracker.dto.request.RedirectRequestDTO;
import com.example.linktracker.dto.response.LinkIdResponseDTO;
import com.example.linktracker.dto.response.LinkMetricsDTO;
import com.example.linktracker.dto.response.RedirectResponseDTO;
import com.example.linktracker.dto.response.ResponseDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.NotFoundException;
import com.example.linktracker.exception.WrongPasswordException;
import com.example.linktracker.repository.ILinkRepository;
import com.example.linktracker.repository.LinkRepositoryImpl;
import com.example.linktracker.utils.RedirectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{
    ILinkRepository linkRepo;

    @Autowired
    public LinkServiceImpl(LinkRepositoryImpl repo) {
        this.linkRepo = repo;
    }

    @Override
    public LinkIdResponseDTO createLink(LinkRequestWithPassword newLink) {
        ObjectMapper objectMapper = new ObjectMapper();
        Link link = objectMapper.convertValue(newLink, Link.class);
        return new LinkIdResponseDTO(linkRepo.save(link));
    }

    @Override
    public RedirectResponseDTO redirect(RedirectRequestDTO linkIdDto) {
        Link link = this.linkRepo.getById(linkIdDto.getLinkId());
        if (link == null) {
            throw new NotFoundException("LinkId no encontrado");
        }
        if (linkIdDto.getPassword() != null &&  !link.getPassword().equals(linkIdDto.getPassword())){
            throw new WrongPasswordException("Usuario no autorizado");
        }
        return RedirectMapper.toRedirectResponseDTO(link);
    }
    @Override
    public LinkMetricsDTO getMetrics(LinkIdMetricsDTO linkId) {
        Optional<Integer> cantidad = Optional.ofNullable(linkRepo.getMetrics(linkId));
        if (cantidad.isEmpty()) {
            throw new NotFoundException("No se han encontrado metricas para el link con id " + linkId);
        }
        return new LinkMetricsDTO(cantidad.get());
    }
    @Override
    public ResponseDTO invalidateLink(int linkID){
        boolean respuesta = this.linkRepo.invalidateLink(linkID);
        if(respuesta){
            return new ResponseDTO("Link con id: " + linkID +  " invalidado correctamente");
        }
        else {
            throw new NotFoundException("El linkId no fue encontrado en la base de datos");
        }

    }
}
