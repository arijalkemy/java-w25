package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;

public interface IBuyerRepository {
    Buyer findBuyerById(Integer id);
    void updateBuyer(Buyer buyer);
    Buyer getById(int id);
}
