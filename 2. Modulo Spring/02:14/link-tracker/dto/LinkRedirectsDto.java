package com.linktraker.ejercicio2.dto;

import com.linktraker.ejercicio2.model.Link;

import lombok.Data;

@Data
public class LinkRedirectsDto {
    private Integer redirects;

    public LinkRedirectsDto(Link link) {
        this.redirects = link.getRedirects();
    }
}
