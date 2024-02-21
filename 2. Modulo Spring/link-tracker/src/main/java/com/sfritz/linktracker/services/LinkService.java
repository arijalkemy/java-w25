package com.sfritz.linktracker.services;

import org.springframework.stereotype.Service;

import com.sfritz.linktracker.dtos.LinkRequestDto;
import com.sfritz.linktracker.dtos.LinkResponseDto;
import com.sfritz.linktracker.entities.Link;
import com.sfritz.linktracker.exceptions.InvalidUrlException;
import com.sfritz.linktracker.repositories.ILinkRepository;
import com.sfritz.linktracker.util.UrlValidator;

@Service
public class LinkService implements ILinkService{

    private ILinkRepository repository;

    public LinkService(ILinkRepository repository){
        this.repository=repository;
    }

    @Override
    public LinkResponseDto createLink(LinkRequestDto requestDto) {
        if(UrlValidator.validateUrl(requestDto.getUrl())){
            Link link = repository.createLink(new Link(0L,requestDto.getUrl(),requestDto.getPassword(),true,0));
            return new LinkResponseDto(link.getLinkId());
        }else{
            throw new InvalidUrlException("La url "+requestDto.getUrl()+" no es valida");
        }
    }

}
