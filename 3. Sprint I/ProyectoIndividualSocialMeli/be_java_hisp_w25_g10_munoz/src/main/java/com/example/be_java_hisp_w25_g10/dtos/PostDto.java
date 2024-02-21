package com.example.be_java_hisp_w25_g10.dtos;

import java.time.LocalDate;
import java.util.Date;

public record PostDto(
        int userId,
        int postId,
        LocalDate date,
        ProductDto product){

}
