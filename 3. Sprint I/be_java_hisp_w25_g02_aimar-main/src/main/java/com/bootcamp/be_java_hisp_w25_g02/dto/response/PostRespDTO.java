package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.bootcamp.be_java_hisp_w25_g02.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PostRespDTO(
        Integer post_id,
        Integer user_id,
        @JsonFormat(pattern = "dd-MM-yyyy") //TODO: corroborar que formatee a dd-MM-yyyy. Es posible agregar "yyyy-MM-dd@HH:mm:ss.SSSZ"
        LocalDate postDate,
        Product product,
        Integer category,
        Double price,
        Boolean has_promo,
        Double discount
) {}
