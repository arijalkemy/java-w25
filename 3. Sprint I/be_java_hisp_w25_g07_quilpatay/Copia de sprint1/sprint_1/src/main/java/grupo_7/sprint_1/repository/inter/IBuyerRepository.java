package grupo_7.sprint_1.repository.inter;

import grupo_7.sprint_1.entity.Buyer;

public interface IBuyerRepository {
    Buyer findBuyerById(Integer id);

    void updateBuyer(Buyer buyer);

    Buyer getById(int id);
}
