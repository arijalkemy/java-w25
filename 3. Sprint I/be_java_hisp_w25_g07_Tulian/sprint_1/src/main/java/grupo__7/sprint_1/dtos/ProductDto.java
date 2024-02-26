package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDto(
        @JsonProperty("product_id") Integer productId,
        @JsonProperty("product_name") String productName,
        @JsonProperty("type") String type,
        @JsonProperty("brand") String brand,
        @JsonProperty("color") String color,
        @JsonProperty("notes") String notes
) {
}
