package com.example.be_java_hisp_w25_g01.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDTO {
    //US 0005
    Integer user_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate date;
    ProductDTO product;
    Integer category;
    Double price;
}
