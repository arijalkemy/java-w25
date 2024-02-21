package grupo_7.sprint_1.dto;

import java.util.List;

public record BuyerDto(
        int userId,
        String userName,
        List<SellerSimpleDto> sellerList
) {
}
