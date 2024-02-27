package com.example.be_java_hisp_w25_g11.repository.seller;

import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class SellerRepositoryImp implements ISellerRepository {
    private final Map<Integer, Seller> sellers;

    public SellerRepositoryImp() {
        this.sellers = new HashMap<>();
    }

    @Override
    public List<Seller> getAll() {
        return sellers
                .values()
                .stream().toList();
    }

    @Override
    public List<Seller> createAll(List<Seller> entities) {
        entities.forEach(s -> sellers.put(s.getId(), s));
        return entities;
    }

    @Override
    public Seller create(Seller user) {
        this.sellers.put(user.getId(), user);

        return user;
    }

    @Override
    public Optional<Seller> get(Integer id) {
        return Optional.ofNullable(sellers.get(id));
    }

    @Override
    public boolean update(Integer id, Seller seller) {
        if (get(id).isEmpty()) {
            return false;
        }

        sellers.put(id,seller);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return sellers.remove(id) != null;
    }

    @Override
    public boolean existing(Integer id) {
        return sellers.containsKey(id);
    }
}
