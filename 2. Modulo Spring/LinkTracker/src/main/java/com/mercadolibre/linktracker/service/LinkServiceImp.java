package com.mercadolibre.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkIdDTO;
import com.mercadolibre.linktracker.dto.MetricDTO;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.NotFoundException;
import com.mercadolibre.linktracker.exception.ResourceAlreadyExistsException;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import com.mercadolibre.linktracker.repository.LinkRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkServiceImp implements ILinkService {

    ILinkRepository linkRepository;
    ObjectMapper mapper = new ObjectMapper();

    public LinkServiceImp(LinkRepositoryImp linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<LinkDTO> getAllLinks() {
        List<Link> linkList = linkRepository.findAll();
        if (linkList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún link en el sistema.");
        }
        return linkList.stream().map(l -> new LinkDTO(l.getId(), l.getUrl(), l.getPassword(), l.getVisitCount(), l.getIsValid())).collect(Collectors.toList());
    }

    @Override
    public LinkDTO getLinkById(Integer id) {
        Link linkFound = linkRepository.findById(id);
        if (linkFound == null) {
            throw new NotFoundException("No se encontró ningún link con ese ID.");
        }
        return mapper.convertValue(linkFound, LinkDTO.class);
    }

    @Override
    public LinkIdDTO addLink(LinkDTO link) {
        Link linkFound = linkRepository.findById(link.getId());
        if (linkFound != null) {
            throw new ResourceAlreadyExistsException("Ya existe un link con ese ID.");
        }
        linkRepository.addLink(mapper.convertValue(link, Link.class));
        return mapper.convertValue(link.getId(), LinkIdDTO.class);
    }

    @Override
    public LinkDTO redirectToLink(Integer id) {
        Link linkFound = linkRepository.findById(id);
        if (linkFound == null) {
            throw new NotFoundException("No se encontró ningún link con ese ID.");
        }
        linkFound.setVisitCount(linkFound.getVisitCount() + 1);
        return mapper.convertValue(linkFound, LinkDTO.class);
    }

    @Override
    public MetricDTO getLinkVisitCounter(Integer id) {
        Link linkFound = linkRepository.findById(id);
        if (linkFound == null) {
            throw new NotFoundException("No se encontró ningún link con ese ID.");
        }
        return mapper.convertValue(linkFound, MetricDTO.class);
    }

    @Override
    public void invalidateLink(Integer id) {
        Link linkFound = linkRepository.findById(id);
        if (linkFound == null) {
            throw new NotFoundException("No se encontró ningún link con ese ID.");
        }
        linkRepository.invalidateLink(id);
    }
}
