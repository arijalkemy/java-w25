package org.example.linktracker.service;

import org.example.linktracker.dto.LinkDto;
import org.example.linktracker.dto.request.LinkDtoRequest;
import org.example.linktracker.dto.response.LinkDtoMetricsResponse;
import org.example.linktracker.dto.response.LinkDtoResponse;
import org.example.linktracker.dto.response.MessageDto;
import org.example.linktracker.entity.Link;
import org.example.linktracker.exception.InvalidateLinkException;
import org.example.linktracker.repository.ILinkRepository;
import org.example.linktracker.utils.MapperDto;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDtoResponse createLink(LinkDtoRequest link) {
        return MapperDto.linkToDtoResponse(linkRepository.createLink(MapperDto.dtoToLink(link)));
    }

    @Override
    public LinkDto redirect(long linkId, String password) {
        Link link = linkRepository.validateLinkPassword(password, linkId);
        if(!link.isValidate()) throw new InvalidateLinkException("Link no valido");
        linkRepository.redirectLink(linkId);
        return MapperDto.linkToDto(link);
    }

    @Override
    public LinkDtoMetricsResponse getLinkMetrics(long linkId) {
        return new LinkDtoMetricsResponse(linkRepository.getLinkById(linkId).getRedirectTimes());
    }

    @Override
    public MessageDto invalidateLink(long linkId) {
        String message = linkRepository.invalidateLink(linkId)
                ? "link validado" : "Link invalidado";
        return new MessageDto(message);
    }
}
