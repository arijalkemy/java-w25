package org.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.socialmeli.entity.Product;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostReqDto {
        Integer userId;
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date;
        Product product;
        Integer category;
        Double price;
}