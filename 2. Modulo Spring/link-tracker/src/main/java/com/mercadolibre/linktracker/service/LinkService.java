package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.request.LinkPostDto;
import com.mercadolibre.linktracker.dto.response.LinkResponseDto;
import com.mercadolibre.linktracker.dto.response.LinkMetricsResponseDto;
import com.mercadolibre.linktracker.exception.BadCredentialsException;
import com.mercadolibre.linktracker.exception.NotFoundException;
import com.mercadolibre.linktracker.model.Link;
import com.mercadolibre.linktracker.repository.LinkRepository;
import com.mercadolibre.linktracker.util.LinkDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;
    private static final String LINK_NOT_FOUND = "Link not found";
    public LinkResponseDto createLink(LinkPostDto linkPostDto) {
        return LinkDtoMapper.toLinkResponseDto(linkRepository.save(LinkDtoMapper.toLink(linkPostDto)));
    }
    public String getRedirectLinkUrl(Integer linkId, String password) {
        Link redirectedLink = linkRepository.findById(linkId)
                .orElseThrow(() -> new NotFoundException(LINK_NOT_FOUND));
        if(!isPasswordValid(redirectedLink, password)){
            throw new BadCredentialsException("Password is invalid");
        }
        redirectedLink.setCount(redirectedLink.getCount() + 1);
        linkRepository.save(redirectedLink);
        return redirectedLink.getUrl();
    }
    public LinkMetricsResponseDto getMetrics(Integer linkId) {
        Link link = linkRepository.findById(linkId)
                .orElseThrow(() -> new NotFoundException(LINK_NOT_FOUND));
        return LinkDtoMapper.toLinkMetricsResponseDto(link);
    }
    public LinkResponseDto invalidateLink(Integer linkId) {
        Link deletedLink = linkRepository.delete(linkId)
                .orElseThrow(() -> new NotFoundException(LINK_NOT_FOUND));
        return LinkDtoMapper.toLinkResponseDto(deletedLink);
    }
    private boolean isPasswordValid(Link link, String password){
        return link.getPassword() != null && link.getPassword().equals(password);
    }
}
