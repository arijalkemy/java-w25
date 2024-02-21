package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto {
        Integer postId;
        Integer userId;
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date;
        ProductDto product;
        Integer category;
        Double price;
        Boolean hasPromo;
        Double discount;

        public PostDto(Integer postId, Integer userId, LocalDate date, ProductDto product, Integer category, Double price) {
                this.postId = postId;
                this.userId = userId;
                this.date = date;
                this.product = product;
                this.category = category;
                this.price = price;
                this.hasPromo = false;
                this.discount = 0.0;
        }
}