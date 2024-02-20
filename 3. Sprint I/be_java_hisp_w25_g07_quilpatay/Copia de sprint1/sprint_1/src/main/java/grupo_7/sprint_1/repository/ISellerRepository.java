package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerRepository {
    Post postPost(Integer sellerId, PostPostDto newPost);

    Optional<Seller> findById(Integer userId);

    int cantidadDeSeguidores(int userId);

    void updateSeller(Seller seller);

    List<Seller> getAllSellers();
}
