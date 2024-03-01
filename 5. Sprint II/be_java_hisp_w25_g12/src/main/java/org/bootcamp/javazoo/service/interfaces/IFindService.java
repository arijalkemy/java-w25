package org.bootcamp.javazoo.service.interfaces;

import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;

public interface IFindService {
    User getUserById(Integer userId);
    Seller getSellerById(int sellerId);
}
