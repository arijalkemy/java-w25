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
}