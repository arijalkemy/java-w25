package grupo_7.sprint_1.dtos;


import java.util.List;


public record BuyerDto(
        int userId,
        String userName,
        List<SellerListDto> sellerList
) {
}
