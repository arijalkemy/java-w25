package it.bootcamp.proyectolinktracker.service;

import it.bootcamp.proyectolinktracker.dto.request.LinkMetricsResponseDTO;
import it.bootcamp.proyectolinktracker.dto.request.LinkRequestDTO;
import it.bootcamp.proyectolinktracker.dto.response.LinkResponseDTO;
import it.bootcamp.proyectolinktracker.entity.Link;
import it.bootcamp.proyectolinktracker.exception.InvalidLinkException;
import it.bootcamp.proyectolinktracker.exception.InvalidPasswordException;
import it.bootcamp.proyectolinktracker.exception.NotFoundException;
import it.bootcamp.proyectolinktracker.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl  implements ILinkService {
    private final ILinkRepository linkRepository;
    private final ModelMapper modelMapper;

    public LinkServiceImpl(
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
