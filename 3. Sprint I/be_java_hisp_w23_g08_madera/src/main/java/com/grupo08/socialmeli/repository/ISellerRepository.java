package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerRepository {
    List<Seller> findAll();

    Optional<Seller> findById(int id);
}
