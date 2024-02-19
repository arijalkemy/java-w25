package com.example.poryectoblog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDto {

    private Integer id;
    private String title;
    private String author;
    private String publicationDate;

}
