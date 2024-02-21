package org.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.socialmeli.dto.response.ProductDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostReqDto {
    Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    ProductDto product;
    Integer category;
    Double price;
    Boolean hasPromo;
    Double discount;
}
