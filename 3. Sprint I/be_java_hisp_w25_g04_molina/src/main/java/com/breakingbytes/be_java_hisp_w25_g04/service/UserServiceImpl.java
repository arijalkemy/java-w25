package com.breakingbytes.be_java_hisp_w25_g04.service;


import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;


import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IUserRepository;
import com.breakingbytes.be_java_hisp_w25_g04.utils.Mapper;
import org.springframework.stereotype.Service;


import java.util.List;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;

import java.time.LocalDate;
import java.util.*;


import java.util.Comparator;
import java.util.stream.Collectors;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    ISellerRepository sellerRepository;
    Mapper mapper;

    public UserServiceImpl(IUserRepository userRepository, ISellerRepository sellerRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.mapper = mapper;
    }

    @Override
    public ResponseDTO unfollowUser(String userId, String userIdToUnfollow) {
        Integer userIdInt = Integer.valueOf(userId),
                userIdToUnfollowInt = Integer.valueOf(userIdToUnfollow);

        Optional<User> userOpt = userRepository.findById(userIdInt);
        if(userOpt.isEmpty()) {
            throw new NotFoundException("Usuario no encontrado.");
        }

        User user = userOpt.get();
        List<Seller> userFollowings = user.getFollowing();
        Optional<Seller> userToUnfollowOpt = userFollowings
                                                    .stream()
                                                    .filter(us -> us.getId() == userIdToUnfollowInt)
                                                    .findFirst();

        if(userToUnfollowOpt.isEmpty()) {
            throw new NotFoundException("El usuario que se quiere dejar de seguir no fue encontrado en los seguidos.");
        }

        Seller sellerToUnfollow = userToUnfollowOpt.get();
        userFollowings.remove(sellerToUnfollow);
        userRepository.setUserFollowings(userIdInt, userFollowings);

        return new ResponseDTO("El usuario " + user.getName() + " ha dejado de seguir a: " + sellerToUnfollow.getName());
    }
    
    

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }


    @Override
    public UserFollowersDTO getUsersFollowersOf(int userId, String order) {
        Optional<Seller> user = this.sellerRepository.findById(userId);
        if(user.isEmpty()) throw new NotFoundException("El ID del vendedor es invalido");
        List<User> userFollowes = user.get().getFollowers();
        if(userFollowes.isEmpty()) throw new NotFoundException("El usuario con id: " + user.get().getId() + " no tiene seguidores");
        List<UserDTO> followers = userFollowes.stream().map(u -> mapper.modelMapper().map(u, UserDTO.class)).toList();
        if(order.equals("name_asc")){
            followers = followers.stream()
                    .sorted(Comparator.comparing(UserDTO::getName))
                    .collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            followers = followers.stream()
                    .sorted(Comparator.comparing(UserDTO::getName, Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        }
        return new UserFollowersDTO(user.get().getId(), user.get().getName(), followers);
    }

    @Override
    public UserFollowedDTO getUsersFollowed(int userId, String order) {
        Optional<User> me = this.userRepository.findById(userId);
        Optional<Seller> seller = this.sellerRepository.findById(userId);
        User user;

        if(!seller.isEmpty()) user = seller.get();
        else if(!me.isEmpty()) user = me.get();
        else throw new NotFoundException("ID de usuario invalido");

        List<Seller> userFolloweds = user.getFollowing();
        if(userFolloweds.isEmpty()) throw new NotFoundException("El usuario con id: " + user.getId() + " no sigue a vendedores");
        List<UserDTO> followed = userFolloweds.stream().map(u -> mapper.modelMapper().map(u, UserDTO.class)).toList();
        if (order.equals("name_asc")){
            followed = followed.stream()
                    .sorted(Comparator.comparing(UserDTO::getName))
                    .collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            followed = followed.stream()
                    .sorted(Comparator.comparing(UserDTO::getName,
                            Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        }
        return new UserFollowedDTO(user.getId(), user.getName(), followed);
    }

    @Override
    public void follow(int userId, int userIdToFollow) {
        Optional<User> me = this.userRepository.findById(userId);
        Optional<Seller> userToFollow = this.sellerRepository.findById(userIdToFollow);

        if (me.isEmpty()) throw new NotFoundException("Ususario no encontrado");
        if (userToFollow.isEmpty()) throw new NotFoundException("Vendedor no encontrado");

        if (userToFollow.get().getFollowers().contains(me.get()))
            throw new BadRequestException("Ya estas siguiendo a ese usuario");

        this.sellerRepository.addFollower(userToFollow.get(), me.get());
        this.userRepository.addFollowing(me.get(), userToFollow.get());
    }
}
