package com.spring.LinkTracker.model;

import lombok.Data;

@Data
public class Link {
    private Integer id;
    private String url;
    private Boolean validate;
    private Integer redirects;
    private static Integer counter = 0;

    public Link(String url) {
        this.id = ++Link.counter;
        this.url = url;
        this.validate = true;
        this.redirects = 0;
    }

}
