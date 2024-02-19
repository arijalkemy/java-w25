package it.bootcamp.proyectolinktracker.entity;

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
