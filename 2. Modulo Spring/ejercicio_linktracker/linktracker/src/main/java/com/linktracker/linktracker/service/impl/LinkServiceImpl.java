package com.linktracker.linktracker.service.impl;

import com.linktracker.linktracker.dto.response.IdLinkDto;
import com.linktracker.linktracker.dto.response.EstadisticasDTO;
import com.linktracker.linktracker.dto.response.RedirectDTO;
import com.linktracker.linktracker.entity.Link;
import com.linktracker.linktracker.exception.InvalidLinkException;
import com.linktracker.linktracker.exception.NotFoundException;
import com.linktracker.linktracker.repository.ILinkRepository;
import com.linktracker.linktracker.service.ILinkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    @Autowired
    ModelMapper modelMapper;

    public IdLinkDto crearLink(String uri, String password){
        return new IdLinkDto(this.linkRepository.saveLink(uri, password).getId());
    }
    public EstadisticasDTO getById(int id){
        Link link = this.linkRepository.getLink(id);

        if(link == null){
            throw new NotFoundException("No se encontró un link con ese ID");
        }

        return new EstadisticasDTO(link.getVisitas());
    }
    public Link invalidar(int id){
        Link link = linkRepository.getLink(id);
        if (!link.getUri().isEmpty()) {
            return this.linkRepository.invalidateLink(id);
        }
        throw new NotFoundException("No se encuentra el link");
    }

    public RedirectDTO redireccion(int id, String password){
        Link redirectLink = this.linkRepository.getLink(id);

        if(redirectLink == null){
            throw new NotFoundException("No se encontró un link con ese ID");
        }

        if(redirectLink.isValido() && redirectLink.getPassword().equals(password)){
            return new RedirectDTO(redirectLink.getUri());
        }

        throw new InvalidLinkException("Link invalido");
    }

}
