package com.link.link.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private String link;
    private String password;
    private int id;
    private int calls;

    public Link(String link, int id) {
        this.link = link;
        this.id = id;
        this.calls = 0;
    }

    public Link(String link, String password, int id) {
        this.link = link;
        this.password = password;
        this.id = id;
        this.calls = 0;
    }
}
