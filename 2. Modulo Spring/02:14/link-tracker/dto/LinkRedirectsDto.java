package com.spring.linktracker.dto;

import com.spring.linktracker.model.Link;

import lombok.Data;

@Data
public class LinkRedirectsDto {
    private Integer redirects;

    public LinkRedirectsDto(Link link) {
        this.redirects = link.getRedirects();
    }
}
