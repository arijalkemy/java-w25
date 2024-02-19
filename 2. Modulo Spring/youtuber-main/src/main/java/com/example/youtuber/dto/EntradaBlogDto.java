package com.example.youtuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDto {

    private int id;
    private String title;
    private String nombreAutor;
    private Date fechaPublicacion;
}
