package com.sfritz.blog.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {

    private Integer id;
    private String title;
    private String author;
    private Date publicationDate;
}
