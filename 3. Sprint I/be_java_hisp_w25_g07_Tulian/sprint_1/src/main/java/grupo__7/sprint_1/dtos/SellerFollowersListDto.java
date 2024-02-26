package grupo_7.sprint_1.dtos;

import java.util.List;

public record SellerFollowersListDto(
        Integer sellerId,
        String sellerUserName,
        List<BuyerDtoRequisito3> buyers
) {
}
