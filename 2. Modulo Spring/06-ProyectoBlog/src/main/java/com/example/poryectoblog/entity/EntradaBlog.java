package com.example.poryectoblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {

    private Integer id;
    private String title;
    private String author;
    private String publicationDate;

}
