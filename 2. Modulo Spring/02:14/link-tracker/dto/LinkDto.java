package com.spring.linktracker.dto;

import com.spring.linktracker.model.Link;

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
