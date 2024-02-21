package grupo_7.sprint_1.service.inter;

import grupo_7.sprint_1.dto.BuyerDto;
import grupo_7.sprint_1.dto.GenericResponseDto;

public interface IBuyerService {
    BuyerDto getBuyerfollows(Integer buyerId, String order);

    GenericResponseDto followSeller(Integer buyerId, Integer sellerId);

    GenericResponseDto unfollowSeller(Integer buyerId, Integer sellerId);
}
