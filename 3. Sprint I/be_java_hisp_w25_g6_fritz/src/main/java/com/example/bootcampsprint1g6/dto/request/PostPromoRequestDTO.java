package com.example.bootcampsprint1g6.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostPromoRequestDTO extends PostRequestDTO{
    @JsonProperty("has_promo")
    Boolean hasPromo;
    Double discount;
}
