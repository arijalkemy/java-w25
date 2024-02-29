package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.repository.interfaces.ISellerRepository;
import org.bootcamp.javazoo.repository.interfaces.IUserRepository;
import org.bootcamp.javazoo.service.interfaces.IFindService;
import org.springframework.stereotype.Service;

@Service
public class FindServiceImpl implements IFindService {
    private final IUserRepository userRepository;
    private final ISellerRepository sellerRepository;

    public FindServiceImpl(IUserRepository userRepository, ISellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public User getUserById(Integer userId){
        User user = userRepository.getById(userId);
        if(user == null) throw new NotFoundException("User not found");
        return user;
    }

    @Override
    public Seller getSellerById(int sellerId){
        Seller seller = sellerRepository.findById(sellerId);
        if (seller == null) throw new NotFoundException("Seller not found");
        return seller;
    }
}
