package com.bootcamp.blog.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTOResponse {

    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

}
