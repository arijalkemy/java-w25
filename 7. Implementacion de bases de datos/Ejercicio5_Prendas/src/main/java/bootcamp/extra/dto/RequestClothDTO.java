package bootcamp.extra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestClothDTO {

    String name;
    String type;
    String brand;
    String color;
    String size;
    Integer amount;
    @JsonProperty("sale_price")
    Double salePrice;
}
