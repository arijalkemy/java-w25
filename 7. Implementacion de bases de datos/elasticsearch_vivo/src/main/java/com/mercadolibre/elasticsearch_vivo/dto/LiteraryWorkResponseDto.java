package com.mercadolibre.elasticsearch_vivo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LiteraryWorkResponseDto {
    String name;
    String author;
    Integer pageCount;
    String editorial;
    Integer firstPublishingYear;
}
