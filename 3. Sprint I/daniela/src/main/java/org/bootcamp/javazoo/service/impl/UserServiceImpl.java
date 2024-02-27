package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.repository.interfaces.IUserRepository;
import org.bootcamp.javazoo.service.interfaces.ISellerService;
import org.bootcamp.javazoo.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    ISellerService sellerService;


    public UserServiceImpl(IUserRepository userRepository, ISellerService sellerService) {
        this.userRepository = userRepository;
        this.sellerService = sellerService;
    }

    @Override
    public FollowersListDto getFollowedList(Integer userId, String order) {
        User user =  userRepository.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        List<UserDto> sellers;
        if (order == null) {
            sellers = user.getFollowed().stream()
                    .map(UserDto::convertUserToUserDto)
                    .toList();
        } else if (order.equals("name_asc")) {
            sellers = user.getFollowed().stream()
                    .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                    .map(UserDto::convertUserToUserDto)
                    .toList();
        } else {
            sellers = user.getFollowed().stream()
                    .sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
                    .map(UserDto::convertUserToUserDto)
                    .toList();
        }

        return new FollowersListDto(userId, user.getName(), sellers);
    }

    @Override
    public User getUserById(Integer userId){
        User user = userRepository.getById(userId);
        if(user == null) throw new NotFoundException("No existe Usuario con id: " + userId);
        return user;
    }

    @Override
    public List<Seller> getUserFollowed(Integer userId){
        User user = getUserById(userId);            // Obtengo el usuario por id
        List<Seller> followed = user.getFollowed(); // Obtendo los Sellers que sigue el user
        if(followed.isEmpty()) throw new NotFoundException("Este usuario con id: " + userId + " no sigue a ningun vendedor");
        /* return user.getFollowed().stream()
                .map(seller -> sellerService.getById(seller.getId()))
                .collect(Collectors.toList());

         */
        return followed;
    }
}
