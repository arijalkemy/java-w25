package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    Integer id;
    @JsonProperty("user_id")
    Integer userId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
}
