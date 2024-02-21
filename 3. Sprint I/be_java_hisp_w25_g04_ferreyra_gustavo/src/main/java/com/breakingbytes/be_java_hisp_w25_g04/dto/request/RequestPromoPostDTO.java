package com.breakingbytes.be_java_hisp_w25_g04.dto.request;

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
public class RequestPromoPostDTO extends RequestPostDTO{
    @JsonProperty("has_promo")
    boolean hasPromo;
    double discount;
}
