package com.obrasliterarias.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    String name;
    String autor;
    Integer totalPages;
    String editorial;
    Integer publicationYear;
}
