package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepositoryImpl implements ISellerRepository {

    private final List<Seller> sellers = new ArrayList<>(
            Arrays.asList(
                    new Seller(1, "Brayan", new ArrayList<>(), new ArrayList<>()),
                    new Seller(2, "Juan", new ArrayList<>(), new ArrayList<>()),
                    new Seller(3, "Carlos", new ArrayList<>(), new ArrayList<>())
            )
    );

    public SellerRepositoryImpl() {
    }

    @Override
    public List<Seller> findAll() {
        return sellers;
    }

    @Override
    public Optional<Seller> findById(int id) {
        return sellers.stream().filter(seller -> seller.getId() == id).findFirst();
    }

}
