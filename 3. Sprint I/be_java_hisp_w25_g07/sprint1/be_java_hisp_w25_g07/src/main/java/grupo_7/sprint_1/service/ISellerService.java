package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.AddPostDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;
import grupo_7.sprint_1.entity.Seller;

import java.util.List;

public interface ISellerService {
    PostDto addPost(Integer sellerId, AddPostDto newPost);

    SellerFollowersListDto getListOrderedAlphabetically(Integer userId, String order);

    SellerDTO cantidadSeguidores(int userID);

    List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order);


}
