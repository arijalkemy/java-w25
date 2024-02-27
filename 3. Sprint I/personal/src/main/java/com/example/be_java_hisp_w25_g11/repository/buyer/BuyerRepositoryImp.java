package com.example.be_java_hisp_w25_g11.repository.buyer;

import com.example.be_java_hisp_w25_g11.entity.Buyer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BuyerRepositoryImp implements IBuyerRepository {
    private final Map<Integer, Buyer> buyers;

    public BuyerRepositoryImp() {
        this.buyers = new HashMap<>();
    }

    @Override
    public List<Buyer> getAll() {
        return buyers
                .values()
                .stream().toList();
    }

    @Override
    public List<Buyer> createAll(List<Buyer> entities) {
        entities.forEach(b -> buyers.put(b.getId(), b));
        return entities;    }

    @Override
    public Buyer create(Buyer buyer) {
        this.buyers.put(buyer.getId(), buyer);

        return buyer;
    }

    @Override
    public Optional<Buyer> get(Integer id) {
        return Optional.ofNullable(buyers.get(id));
    }

    @Override
    public boolean update(Integer id, Buyer buyer) {
        if (get(id).isEmpty()) {
            return false;
        }

        buyers.put(id,buyer);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return buyers.remove(id) != null;
    }

    @Override
    public boolean existing(Integer id) {
        return buyers.containsKey(id);
    }
}
