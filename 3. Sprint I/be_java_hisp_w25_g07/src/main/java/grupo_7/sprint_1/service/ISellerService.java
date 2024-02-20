package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;
import grupo_7.sprint_1.entity.Seller;

import java.util.List;

public interface ISellerService {
    PostDto postPost(Integer sellerId, PostPostDto newPost);

    SellerFollowersListDto getListOrderedAlphabetically(Integer userId, boolean orderAsc);

    SellerDTO cantidadSeguidores(int userID);

    List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order);

    List<Seller> getAllSellers();
}
