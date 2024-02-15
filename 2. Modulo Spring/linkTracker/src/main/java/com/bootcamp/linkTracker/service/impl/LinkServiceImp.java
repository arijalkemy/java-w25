package com.bootcamp.linkTracker.service.impl;

import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.response.ExceptionDTO;
import com.bootcamp.linkTracker.dto.response.LinkResponseDTO;
import com.bootcamp.linkTracker.dto.response.ResponseDTO;
import com.bootcamp.linkTracker.dto.response.StatisticsDTO;
import com.bootcamp.linkTracker.entity.Link;
import com.bootcamp.linkTracker.exception.InvalidateLinkException;
import com.bootcamp.linkTracker.exception.NotFoundLinkException;
import com.bootcamp.linkTracker.repository.ILinkRepository;
import com.bootcamp.linkTracker.repository.LinkRepositoryImp;
import com.bootcamp.linkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImp implements ILinkService {

    private final ILinkRepository linkRepository;

    @Autowired
    public LinkServiceImp(LinkRepositoryImp linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public ResponseDTO createLink(LinkDTO linkDTO) {
        Link link = new Link(linkRepository.getNextId(), linkDTO.getUrl(), linkDTO.getPassword());
        if(link.validate()){
            linkRepository.saveLink(link);
        }else{
         throw new InvalidateLinkException("Formato de link invalido");
        }
        return new ResponseDTO(link.getLinkId());
    }
    @Override
    public LinkResponseDTO redirectLink(Long linkId) {
        Optional<Link> linkARedireccionar = linkRepository.getById(linkId);

        if (!linkARedireccionar.isPresent())
            throw new NotFoundLinkException("El id "+ linkId+" ingresado no está registrado" );
        Link link = linkARedireccionar.get();
        if(!link.getActive())
            throw new NotFoundLinkException("El link con id " + linkId + " se encuentra inactivo");
        link.agregarVisita();
        return new LinkResponseDTO(link.getUrl());
    }
    @Override
    public StatisticsDTO getStatistics(Long linkId){
        Optional<Link> link = linkRepository.getById(linkId);
        if (!link.isPresent())
            throw new NotFoundLinkException("El id ingresado no está registrado " + linkId);
        return new StatisticsDTO(link.get().getVisitas());
    }
    @Override
    public void invalidateLink(Long linkID){
        linkRepository.invalidateLink(linkID);
    }


}
