package com.be_java_hisp_w25_g02_zanaboni.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PostDTO(
        Integer user_id,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date,
        ProductDTO product,
        Integer category,
        Double price,
        Boolean has_promo,
        Double discount) {
}
