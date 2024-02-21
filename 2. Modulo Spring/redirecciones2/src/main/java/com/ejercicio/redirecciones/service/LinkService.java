package com.ejercicio.redirecciones.service;

import com.ejercicio.redirecciones.dto.LinkDTO;
import com.ejercicio.redirecciones.dto.MetricDTO;
import com.ejercicio.redirecciones.entity.Link;
import com.ejercicio.redirecciones.exception.AlreadyInvalidException;
import com.ejercicio.redirecciones.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    private final ILinkRepository linkRepository;

    ModelMapper modelMapper = new ModelMapper();

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTO createLink(LinkDTO linkDTO) {
        linkRepository.addLink(modelMapper.map(linkDTO, Link.class));
        return linkDTO;
    }

    @Override
    public LinkDTO findLinkById(Integer id) {
        Link link =  linkRepository.findLinkById(id);
        return new LinkDTO(link.getId(), link.getUrl(), link.getPassword(), link.getStatus(), link.getCounter());
    }

    @Override
    public boolean invalidateLink(Integer id) {

        return linkRepository.invalidateLink(id);
    }

    @Override
    public LinkDTO redirect(Integer id) {
        Link link = linkRepository.findLinkById(id);
        if(!link.getStatus()) throw new AlreadyInvalidException("Link desactivado");
        link.setCounter(link.getCounter()+1);
        return modelMapper.map(link, LinkDTO.class);
    }

    @Override
    public MetricDTO getLinkCounter(Integer id) {
        return new MetricDTO(id,linkRepository.findLinkById(id).getCounter());
    }
}
