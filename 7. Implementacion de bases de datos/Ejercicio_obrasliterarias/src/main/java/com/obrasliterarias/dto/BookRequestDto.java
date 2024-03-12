package com.obrasliterarias.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDto {

    String name;
    String autor;
    Integer totalPages;
    String editorial;
    Integer publicationYear;

}
