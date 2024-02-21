package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PostDTO(

        

        Integer user_id,
@JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date,
        ProductDTO product,
        Integer category,
        Double price
) { }
