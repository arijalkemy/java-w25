package grupo_7.sprint_1.repository.inter;

import grupo_7.sprint_1.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerRepository {

    Optional<Seller> findById(Integer sellerId);

    Integer countFollowers(Integer sellerId);

    void update(Seller seller);

    Integer countSellerPromos(Integer sellerId);

    List<Seller> getAll();

}
