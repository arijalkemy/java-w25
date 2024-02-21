package com.bootcamp.be_java_hisp_w25_g9.dto.response;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.PromoPostDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.model.PromoPost;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PromoPostResponseDto(
        int user_id,
        String user_name,
        List<PromoPostDto> posts
){
}
