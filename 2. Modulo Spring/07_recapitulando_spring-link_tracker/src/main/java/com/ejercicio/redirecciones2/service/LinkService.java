package com.ejercicio.redirecciones2.service;

import com.ejercicio.redirecciones2.dto.LinkDTO;
import com.ejercicio.redirecciones2.dto.MetricDTO;
import com.ejercicio.redirecciones2.entity.Link;
import com.ejercicio.redirecciones2.repository.ILinkRepository;
import lombok.AllArgsConstructor;
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

        link.setCounter(link.getCounter()+1);
        return modelMapper.map(link, LinkDTO.class);
    }

    @Override
    public MetricDTO getLinkCounter(Integer id) {
        return new MetricDTO(id,linkRepository.findLinkById(id).getCounter());
    }
}
