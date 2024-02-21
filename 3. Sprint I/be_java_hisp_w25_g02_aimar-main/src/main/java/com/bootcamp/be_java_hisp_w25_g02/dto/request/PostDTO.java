package com.bootcamp.be_java_hisp_w25_g02.dto.request;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
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
        Double discount
) { }
