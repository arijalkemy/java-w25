package com.social.meli.entity;

import com.social.meli.dto.request.PromoPostDto;
import com.social.meli.dto.response.PostDto;
import com.social.meli.dto.response.PromoPostResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
public class PromoPost extends Post {
    Double discount;
    public PromoPost(Integer id, PromoPostDto promoPostDto){
        super(id,promoPostDto);
        this.discount = promoPostDto.getDiscount();
    }
    @Override
    public PostDto toDto(Product product){
        return new PromoPostResponseDto(this,product);
    }
}
