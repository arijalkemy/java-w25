package com.mercadolibre.elasticsearch_vivo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateLiteraryWorkDto {
    String name;
    String author;
    @JsonProperty("page_count")
    Integer pageCount;
    String editorial;
    @JsonProperty("first_publishing_year")
    Integer firstPublishingYear;
}
