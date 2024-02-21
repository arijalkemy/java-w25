package com.sfritz.blog.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {

    private Integer id;
    private String title;
    private String author;
    private Date publicationDate;
}
