package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerRepository {

    Optional<Seller> findById(Integer userId);

    int cantidadDeSeguidoresRepo(int userId);

    void updateSeller(Seller seller);

    List<Seller> getAllSellers();
}
