package grupo_7.sprint_1.dto;

import java.util.List;

public record SellerFollowersListDto(
        Integer sellerId,
        String sellerUserName,
        List<BuyerSimpleDto> buyers
) {
}
