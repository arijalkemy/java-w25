package com.breakingbytes.be_java_hisp_w25_g04.service;


import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;


import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IUserRepository;
import com.breakingbytes.be_java_hisp_w25_g04.utils.Mapper;
import org.springframework.stereotype.Service;


import java.util.List;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;


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


    // Ejercicio 0007
    @Override
    public ResponseDTO unfollow(String userId, String userIdToUnfollow) {
        Integer userIdInt = Integer.valueOf(userId),
                userIdToUnfollowInt = Integer.valueOf(userIdToUnfollow);

        Optional<User> userOpt = userRepository.findById(userIdInt);
        if(userOpt.isEmpty()) throw new NotFoundException("Usuario no encontrado");
        User user = userOpt.get();

        Optional<Seller> userToUnfollowOpt = sellerRepository.findById(userIdToUnfollowInt);
        if(userToUnfollowOpt.isEmpty()) throw new NotFoundException("El usuario que se quiere dejar de seguir no fue encontrado en los seguidos.");
        Seller sellerToUnfollow = userToUnfollowOpt.get();

        sellerToUnfollow.removeFollower(user);

        return new ResponseDTO("El usuario " + user.getName() + " ha dejado de seguir a: " + sellerToUnfollow.getUser().getName());
    }


    // Ejercicio 0004
    @Override
    public UserFollowedDTO getUsersFollowed(int userId, String order) {
        Optional<User> me = this.userRepository.findById(userId);
        if(me.isEmpty()) throw new NotFoundException("ID de usuario invalido");
        List<Seller> userFolloweds = this.sellerRepository.findFollowedsUser(me.get());
        if(userFolloweds.isEmpty()) throw new NotFoundException("El usuario con id: " + me.get().getId() + " no sigue a vendedores");
        List<UserDTO> followed = userFolloweds.stream().map(u -> mapper.modelMapper().map(u.getUser(), UserDTO.class)).toList();

        followed = followed.stream().sorted(Comparator.comparing(UserDTO::getName)).toList();
        if (order.equals("name_asc")) followed = followed.stream().collect(Collectors.toList());
        else if(order.equals("name_desc")) followed = followed.stream().collect(Collectors.toList());

        return new UserFollowedDTO(me.get().getId(), me.get().getName(), followed);
    }

    // Ejercicio 0001
    @Override
    public void follow(int userId, int userIdToFollow) {
        Optional<User> me = this.userRepository.findById(userId); // Vendedores y Usuarios comunes

        if (me.isEmpty()) throw new NotFoundException("Usuario no encontrado");

        Optional<Seller> userToFollow = this.sellerRepository.findById(userIdToFollow);

        if (userToFollow.isEmpty()) throw new NotFoundException("Vendedor no encontrado");

        if(userToFollow.get().getFollowers().contains(me.get())) throw new BadRequestException("Ya estas siguiendo a ese usuario");

        userToFollow.get().addFollower(me.get());
    }
}
