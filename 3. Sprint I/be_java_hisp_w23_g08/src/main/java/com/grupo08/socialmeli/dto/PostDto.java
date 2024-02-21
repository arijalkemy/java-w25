package com.grupo08.socialmeli.dto;

import com.grupo08.socialmeli.entity.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto implements  Comparable<PostDto> {
    Integer userId;
    String date;
    Product product;
    Integer category;
    Double price;

    @Override
    public int compareTo(PostDto postDto){
return this.date.compareTo(postDto.getDate());
    }
}
