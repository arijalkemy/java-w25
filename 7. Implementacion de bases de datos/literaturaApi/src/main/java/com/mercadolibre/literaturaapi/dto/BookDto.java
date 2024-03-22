package com.mercadolibre.literaturaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {

    String author;
    String title;
    Integer pages;
    @JsonProperty("publish_year")
    Integer publishYear;
    String publisher;
}
