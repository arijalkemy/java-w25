package org.bootcamp.javazoo.repository.interfaces;

import org.bootcamp.javazoo.entity.Seller;

import java.util.stream.Stream;

public interface ISellerRepository {
    Seller findById(Integer id);
    Stream<Seller> getCountPromos(Integer user_id);
}
