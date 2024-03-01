package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.entity.Buyer;

import java.util.List;
import java.util.Optional;

public interface IBuyerRepository {
    List<Buyer> findAll();

    Optional<Buyer> findById(int id);
}
