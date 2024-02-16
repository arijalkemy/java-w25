package com.ejemplo.linkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Link {

    private String link;
    private Integer count;
    private boolean valid;
    private String password;
}
