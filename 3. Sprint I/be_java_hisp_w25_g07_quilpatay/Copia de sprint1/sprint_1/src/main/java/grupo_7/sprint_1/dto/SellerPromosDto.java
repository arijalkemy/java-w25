package grupo_7.sprint_1.dto;

import grupo_7.sprint_1.entity.Post;

import java.util.List;

public record SellerPromosDto(
        int userId,
        String userName,
        List<PostDto> posts
) {
}
