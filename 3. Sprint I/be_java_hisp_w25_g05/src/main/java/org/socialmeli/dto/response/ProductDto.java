package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    @JsonProperty("product_id")
    Integer productId;
    @JsonProperty("product_name")
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
