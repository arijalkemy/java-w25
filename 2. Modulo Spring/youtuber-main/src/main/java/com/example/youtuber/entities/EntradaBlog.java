package com.example.youtuber.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String title;
    private String nombreAutor;
    private Date fechaPublicacion;
}
