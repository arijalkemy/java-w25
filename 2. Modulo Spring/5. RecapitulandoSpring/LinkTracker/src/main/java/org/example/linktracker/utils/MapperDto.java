package org.example.linktracker.utils;

import org.example.linktracker.dto.LinkDto;
import org.example.linktracker.dto.request.LinkDtoRequest;
import org.example.linktracker.dto.response.LinkDtoResponse;
import org.example.linktracker.entity.Link;

public class MapperDto {

    public static Link dtoToLink(LinkDtoRequest link){
        return new Link(link.id(),link.password(),link.link(), 0, true);
    }

    public static LinkDtoResponse linkToDtoResponse(Link link){
        return new LinkDtoResponse(link.getId());
    }

    public static LinkDto linkToDto(Link link){
        return new LinkDto(link.getId(),link.getPassword(),link.getLink());
    }


}
