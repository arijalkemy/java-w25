package org.socialmeli.dto.request.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BasePostReqDto {
    Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    Product product;
    Integer category;
    Double price;

    public abstract Post sendToPostMapper();
}
