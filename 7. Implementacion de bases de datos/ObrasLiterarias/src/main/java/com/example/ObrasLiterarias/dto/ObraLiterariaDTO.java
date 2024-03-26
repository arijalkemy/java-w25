package com.example.ObrasLiterarias.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDTO {
    String name;
    String author;
    int pages;
    String editorial;
    int publishYear;
}
