package com.example.bootcampsprint1g6.dto.response;

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
public class PostPromoResponseDTO extends PostResponseDTO{

    @JsonProperty("has_promo")
    Boolean hasPromo;
    Double discount;
}
