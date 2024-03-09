package com.bootcamp.ejercicio_mini_series.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MiniserieRequestDTO {
    private String name;
    private Double rating;
    @JsonProperty("amount_of_awards")
    private int amountOfAwards;

}
