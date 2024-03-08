package com.bootcamp.ejercicio_link_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer linkId;
    private String url;
    private String password;
    private Integer metrics;
    private boolean isValid;
}
