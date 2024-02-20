package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CountPromosDto (
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName,
        @JsonProperty("promo_products_count")
        Integer countPromos
){
}
