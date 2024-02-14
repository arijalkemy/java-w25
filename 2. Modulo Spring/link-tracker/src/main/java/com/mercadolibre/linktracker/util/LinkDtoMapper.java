package com.mercadolibre.linktracker.util;

import com.mercadolibre.linktracker.dto.request.LinkPostDto;
import com.mercadolibre.linktracker.dto.response.LinkResponseDto;
import com.mercadolibre.linktracker.dto.response.LinkMetricsResponseDto;
import com.mercadolibre.linktracker.model.Link;

public final class LinkDtoMapper {
    private LinkDtoMapper() {
    }
    public static LinkResponseDto toLinkResponseDto(Link link) {
        return new LinkResponseDto(link.getId(), link.getUrl(), link.getCount());
    }
    public static Link toLink(LinkPostDto linkPostDto){
        return new Link(linkPostDto.getUrl(), linkPostDto.getPassword());
    }
    public static LinkMetricsResponseDto toLinkMetricsResponseDto(Link link) {
        return new LinkMetricsResponseDto(link.getCount());
    }
}
