package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PostPromoListDto(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName,
        @JsonProperty("posts")
        List<PostPromoDto> postList
) {
}
