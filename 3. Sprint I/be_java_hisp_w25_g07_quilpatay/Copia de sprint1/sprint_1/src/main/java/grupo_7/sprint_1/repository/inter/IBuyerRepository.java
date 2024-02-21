package grupo_7.sprint_1.repository.inter;

import grupo_7.sprint_1.entity.Buyer;

import java.util.Optional;

public interface IBuyerRepository {
    Optional<Buyer> findById(Integer buyerId);

    void update(Buyer buyer);
}
