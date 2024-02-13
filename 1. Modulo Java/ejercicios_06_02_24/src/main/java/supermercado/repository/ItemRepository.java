package supermercado.repository;

import supermercado.model.Item;

public interface ItemRepository {
    Item getItem();
    Item postItem();
    Item deleteItem();
    Item putItem();
}
