package grupo_7.sprint_1.service.inter;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Seller;

import java.util.List;

public interface ISellerService {
    PostDto postPost(Integer sellerId, PostPostDto newPost);

    SellerFollowersListDto getListOrderedAlphabetically(Integer userId, boolean orderAsc);

    SellerDto cantidadSeguidores(int userID);

    List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order);

    List<Seller> getAllSellers();

    PostDiscountDto postPostDiscount(Integer sellerId, PostDiscountPostDto newPost);
}
