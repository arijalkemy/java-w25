package com.lh.bootjavaspring_profiles_vivo_p2.service;

import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkAuthDTO;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPost;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPostInvalidate;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.response.LinkDTOGetStats;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.AlreadyExistsException;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.NotFoundLinkException;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.UnauthorizedLinkException;
import com.lh.bootjavaspring_profiles_vivo_p2.model.Link;
import com.lh.bootjavaspring_profiles_vivo_p2.repository.ILinkRepository;
import com.lh.bootjavaspring_profiles_vivo_p2.repository.LinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;
    private final ModelMapper mapper;

    public LinkService(LinkRepository linkRepository, ModelMapper mapper) {
        this.linkRepository = linkRepository;
        this.mapper = mapper;
    }

    @Override
    public LinkDTOGetStats post(LinkDTOPost url) {
        Optional<Link> linkBuscado = linkRepository.getByUrl(url.getUrl());
        if (!linkBuscado.isEmpty()) throw new AlreadyExistsException("Ya existe un link con la URL " + url.getUrl());
        Link l = linkRepository.post(url);
        return mapper.map(l, LinkDTOGetStats.class);
    }

    @Override
    public LinkDTOGetStats postInvalidate(LinkDTOPostInvalidate id) {
        Optional<Link> linkOpt = linkRepository.postInvalidate(id);
        if (linkOpt.isEmpty()) {
            throw new NotFoundLinkException(String.format("No se encontró el link con el ID " + id.getId()));
        }
        return mapper.map(linkOpt.get(), LinkDTOGetStats.class);
    }

    @Override
    public LinkDTOGetStats getStatsLink(Long id) {
        Optional<Link> foundLink = linkRepository.getById(id);
        if (foundLink.isEmpty())
            throw new NotFoundLinkException(String.format("No se encontró el link con el ID " + id));
        return mapper.map(foundLink, LinkDTOGetStats.class);
    }

    @Override
    public LinkDTOGetStats getLinkRedirect(LinkAuthDTO linkAuthDTO) {
        Optional<Link> foundLink = linkRepository.getById(linkAuthDTO.getId());
        if (foundLink.isEmpty()) throw new NotFoundLinkException(
                String.format("No se encontró el link con el ID " + linkAuthDTO.getId()
                ));
        if (!foundLink.get().getPassword().equals(linkAuthDTO.getPassword()))
            throw new UnauthorizedLinkException("La contraseña es incorrecta");
        return mapper.map(foundLink.get(), LinkDTOGetStats.class);
    }
}
