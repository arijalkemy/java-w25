package com.mercadolibre.be_java_hisp_w25_g15.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.ProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostListDto;
import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Getter
public class ObjectMapperBean {
    private final ObjectMapper mapper;


    public ObjectMapperBean() {
        this.mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);
    }

    public PostDto postToPostDto(Post post){
        return new PostDto(
                post.getUser().getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyy")),
                this.mapper.convertValue(post.getProduct(), ProductDto.class),
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
        );
    }

    public PostListDto postToPostListDto(Post post){
        return new PostListDto(
                post.getUser().getId(),
                post.getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                post.getProduct(),
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
        );
    }

}
