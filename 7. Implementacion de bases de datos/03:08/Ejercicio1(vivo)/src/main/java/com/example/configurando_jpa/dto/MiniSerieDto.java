package com.example.configurando_jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MiniSerieDto {
    Long id;

    String name;

    Double rating;

    @JsonProperty("amount_of_awards")
    Integer amountOfAwards;
}
