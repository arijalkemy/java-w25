package grupo_7.sprint_1.service.inter;

import grupo_7.sprint_1.dto.*;
import grupo_7.sprint_1.entity.Seller;

import java.util.List;

public interface ISellerService {
    PostDto addPost(Integer sellerId, AddPostDto newPost);

    SellerFollowersListDto getListOrderedAlphabetically(Integer sellerId, String order);

    SellerDto cantidadSeguidores(Integer sellerId);

    List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order);

    SellerPromosListDto getSellerPromosCount(Integer sellerId);

    SellerPromosDto getPromoPostsBySeller(Integer sellerId);

    List<Seller> getAllSellers();
}
