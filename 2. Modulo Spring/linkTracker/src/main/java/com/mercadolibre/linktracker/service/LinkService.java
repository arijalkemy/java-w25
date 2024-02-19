package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDto;
import com.mercadolibre.linktracker.dto.LinkStadisticDto;
import com.mercadolibre.linktracker.dto.MaskLinkDto;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.repository.LinkRepoImp;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private final String BASEURI= "http://localhost:8080/api/link/";
    private LinkRepoImp linkRepo;

    public LinkService(LinkRepoImp linkRepo) {
        this.linkRepo = linkRepo;
    }

    public LinkDto getById(Integer id, String password){
        Link link = this.linkRepo.getById(id, password);
        return new LinkDto(link.getLink(), link.getPassword());
    }

    public MaskLinkDto add(LinkDto linkDto){
        Integer id = this.linkRepo.add(new Link(linkDto.getLink(), 0 , true, linkDto.getPassword()));
        return new MaskLinkDto(BASEURI+id);
    }

    public LinkStadisticDto getStadistic(Integer id){
        Link link= this.linkRepo.getById(id);
        return new LinkStadisticDto(link.getLink(), link.getCounter());
    }

    public void  disable(Integer id){
        this.linkRepo.disable(id);
    }
}
