package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.entity.Buyer;
import com.grupo08.socialmeli.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BuyerRepositoryImpl implements IBuyerRepository {
    private final List<Buyer> listBuyers = new ArrayList<>(Arrays.asList(
        new Buyer(1, "Fabian", new ArrayList<>()),
        new Buyer(2, "Miguel", new ArrayList<>()),
        new Buyer(3, "Andres", new ArrayList<>()),
        new Buyer(4, "Pablo", new ArrayList<>()),
        new Buyer(5, "Paula", new ArrayList<>()),
        new Buyer(6, "Andrea", new ArrayList<>())
    ));


    public BuyerRepositoryImpl() {
    }

    @Override
    public List<Buyer> findAll() {
        return listBuyers;
    }

    @Override
    public Optional<Buyer> findById(int id) {
        return listBuyers.stream().filter(buyer -> buyer.getId() == id).findFirst();
    }
}
