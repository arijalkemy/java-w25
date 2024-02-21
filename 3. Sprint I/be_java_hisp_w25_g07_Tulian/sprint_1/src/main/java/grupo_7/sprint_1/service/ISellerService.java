package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Seller;

import java.util.List;

public interface ISellerService {
    PostDto addPost(Integer sellerId, AddPostDto newPost);

    SellerFollowersListDto getListOrderedAlphabetically(Integer userId, String order);

    SellerDTO cantidadSeguidores(int userID);

    List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order);

    List<Seller> getAllSellers();

    SellerPromDto cantidadProductosPromocion(int userId);

    ListPostSellerDto listaPostsPromocion(int userId);
}
