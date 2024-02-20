package grupo_7.sprint_1.service.inter;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.GenericResponseDto;
import grupo_7.sprint_1.dtos.MessageDto;

public interface IBuyerService {
    BuyerDto getBuyerfollow(Integer buyer, String order);

    GenericResponseDto followSeller(Integer buyerId, Integer sellerId);

    MessageDto unfollowSeller(int idUser, int userIdToUnfollow);
}
