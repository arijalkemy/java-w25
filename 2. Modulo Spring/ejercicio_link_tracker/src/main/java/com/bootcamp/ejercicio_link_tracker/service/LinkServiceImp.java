package com.bootcamp.ejercicio_link_tracker.service;
import com.bootcamp.ejercicio_link_tracker.dto.request.LinkMetricsResponseDTO;
import com.bootcamp.ejercicio_link_tracker.dto.request.LinkRequestDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.ejercicio_link_tracker.entity.Link;
import com.bootcamp.ejercicio_link_tracker.exception.InvalidLinkException;
import com.bootcamp.ejercicio_link_tracker.exception.InvalidPasswordException;
import com.bootcamp.ejercicio_link_tracker.exception.NotFoundException;
import com.bootcamp.ejercicio_link_tracker.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImp  implements ILinkService {
    private final ILinkRepository linkRepository;
    private final ModelMapper modelMapper;

    public LinkServiceImp(
            ILinkRepository linkRepository,
            ModelMapper modelMapper
    ) {
        this.linkRepository = linkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LinkResponseDTO create(LinkRequestDTO request) {
        Link newLink = modelMapper.map(request, Link.class);
        newLink.setValid(true);
        newLink.setMetrics(0);

        return modelMapper
                .map(linkRepository.create(newLink), LinkResponseDTO.class);
    }

    @Override
    public String redirect(Integer linkId, String password) {
        Optional<Link> link = linkRepository.findById(linkId);
        if (link.isEmpty())
            throw new NotFoundException("Link with provided ID does not exist");

        if (!link.get().isValid())
            throw new InvalidLinkException("Link with provided ID is invalid");

        linkRepository.addMetric(linkId);
        return link.get().getUrl();
    }

    @Override
    public LinkMetricsResponseDTO getMetrics(Integer linkId) {
        Optional<Link> link = linkRepository.findById(linkId);
        if (link.isEmpty())
            throw new NotFoundException("Link with provided ID does not exist");

        return modelMapper.map(link.get(), LinkMetricsResponseDTO.class);
    }

    @Override
    public void invalidate(Integer linkId, String password) {
        Optional<Link> link = linkRepository.findById(linkId);
        if (link.isEmpty())
            throw new NotFoundException("Link with provided ID does not exist");
        if (!link.get().getPassword().equals(password))
            throw new InvalidPasswordException("Password is incorrect");

        linkRepository.invalidate(linkId);
    }
}
