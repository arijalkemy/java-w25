package com.spring.LinkTracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.LinkTracker.dto.LinkDto;
import com.spring.LinkTracker.dto.LinkIdDto;
import com.spring.LinkTracker.dto.LinkRedirectsDto;
import com.spring.LinkTracker.dto.LinkUrlDto;
import com.spring.LinkTracker.dto.req.LinkReqDto;
import com.spring.LinkTracker.exception.NotFoundException;
import com.spring.LinkTracker.model.Link;
import com.spring.LinkTracker.repository.LinkRepository;

@Service
public class LinkService implements ILinkService {
    @Autowired
    LinkRepository linkRepository;

    private LinkDto convertLinkToDto(Link v) {
        return new LinkDto(v);
    }

    // 1
    @Override
    public LinkIdDto postLink(LinkUrlDto linkUrlDto) {
        Link link = new Link(linkUrlDto.getUrl());
        return new LinkIdDto(linkRepository.postLink(link));
    }

    // 2
    public LinkDto redirectLink(LinkReqDto linkReqDto) {
        LinkDto linkDto = null;
        for (Link link : linkRepository.getLinks()) {
            if (link.getId().equals(linkReqDto.getId()) && link.getValidate()) {
                link.setRedirects(link.getRedirects() + 1);
                ;
                linkRepository.putLink(link);
                linkDto = new LinkDto(link);
            }
        }
        return linkDto;
    }

    // 3
    @Override
    public LinkRedirectsDto getMetrics(LinkReqDto id) {
        Link link = linkRepository.getMetrics(id.getId());
        if (link == null) {
            throw new NotFoundException("No se encontró ningun link en el sistema con el id indicado.");
        }
        return new LinkRedirectsDto(link);
    }

    // 4
    @Override
    public LinkIdDto putLink(Integer linkIdDto) {
        for (Link link : linkRepository.getLinks()) {
            if (link.getId().equals(linkIdDto)) {
                link.setValidate(false);
                linkRepository.putLink(link);
                return new LinkIdDto(link);
            }
        }
        throw new NotFoundException("No se encontró ningun link en el sistema con el id indicado.");
    }

    // aux
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

}
