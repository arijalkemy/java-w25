package com.spring.linktracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.linktracker.dto.LinkDto;
import com.spring.linktracker.dto.LinkIdDto;
import com.spring.linktracker.dto.LinkRedirectsDto;
import com.spring.linktracker.dto.LinkUrlDto;
import com.spring.linktracker.dto.req.LinkReqDto;
import com.spring.linktracker.exception.NotFoundException;
import com.spring.linktracker.model.Link;
import com.spring.linktracker.repository.LinkRepository;

@Service
public class LinkService implements ILinkService {
    @Autowired
    LinkRepository linkRepository;

    private LinkDto convertLinkToDto(Link v) {
        return new LinkDto(v);
    }

    @Override
    public LinkIdDto postLink(LinkUrlDto linkUrlDto) {
        Link link = new Link(linkUrlDto.getUrl());
        return new LinkIdDto(linkRepository.postLink(link));
    }

    @Override
    public List<LinkDto> getLinks() {
        List<Link> linkList = linkRepository.getLinks();
        if (linkList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun link en el sistema.");
        }
        return linkList.stream()
                .map(this::convertLinkToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LinkIdDto putLink(Integer linkIdDto) {
        for (Link link : linkRepository.getLinks()) {
            if (link.getId().intValue() == linkIdDto) {
                if (link.getValidate()) {
                    link.setValidate(false);
                } else {
                    link.setValidate(true);
                }
                linkRepository.putLink(link);
                return new LinkIdDto(link);
            }
        }
        throw new NotFoundException("No se encontró ningun link en el sistema con el id indicado.");
    }

    @Override
    public LinkRedirectsDto getMetrics(LinkReqDto id) {
        Link link = linkRepository.getMetrics(id.getId());
        if (link == null) {
            throw new NotFoundException("No se encontró ningun link en el sistema con el id indicado.");
        }
        return new LinkRedirectsDto(link);
    }

}
