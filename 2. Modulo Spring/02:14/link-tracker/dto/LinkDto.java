package com.linktraker.ejercicio2.dto;

import com.linktraker.ejercicio2.model.Link;

import lombok.Data;

@Data
public class LinkDto {

    private Integer id;
    private String url;
    private Boolean validate;
    private Integer redirects;

    public LinkDto(Link link) {
        this.id = link.getId();
        this.url = link.getUrl();
        this.validate = link.getValidate();
        this.redirects = link.getRedirects();
    }

}
