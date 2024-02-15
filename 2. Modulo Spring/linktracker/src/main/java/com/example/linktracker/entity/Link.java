package com.example.linktracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link {

    private String url;
    private String password;
    private Integer id;
    private Boolean valido = true;
    private Integer contador;

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
        this.contador = 0;
    }
}
