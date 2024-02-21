package com.spring.LinkTracker.dto;

import com.spring.LinkTracker.model.Link;

import lombok.Data;

@Data
public class LinkRedirectsDto {
    private Integer redirects;

    public LinkRedirectsDto(Link link) {
        this.redirects = link.getRedirects();
    }
}
