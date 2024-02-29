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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
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
    ModelMapper mapper = new ModelMapper(); // ?????

    public UserServiceImpl(IUserRepository userRepository, ISellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    @Override
    public ResponseDTO unfollowUser(Integer userIdInt, Integer userIdToUnfollowInt) {

        Optional<User> userOpt = userRepository.findById(userIdInt);
        if(userOpt.isEmpty()) {
            throw new NotFoundException("Usuario no encontrado.");
        }

        User user = userOpt.get();
        List<Seller> userFollowings = user.getFollowing();
        Optional<Seller> userToUnfollowOpt = userFollowings
                                                    .stream()
                                                    .filter(us -> Objects.equals(us.getId(), userIdToUnfollowInt))
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
    public UserFollowersDTO getUsersFollowersOf(Integer userId, String order) {
        Optional<Seller> user = this.sellerRepository.findById(userId);
        if(user.isEmpty()) throw new NotFoundException("El ID del vendedor es invalido");
        List<User> userFollowes = user.get().getFollowers();
        if(userFollowes.isEmpty()) throw new NotFoundException("El usuario con id: " + user.get().getId() + " no tiene seguidores");
        List<UserDTO> followers = userFollowes.stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        return new UserFollowersDTO(user.get().getId(), user.get().getName(), ordenarUsuariosPorNombre(followers, order));
    }

    @Override
    public UserFollowedDTO getUsersFollowed(Integer userId, String order) {
        Optional<User> me = this.userRepository.findById(userId);
        Optional<Seller> seller = this.sellerRepository.findById(userId);
        User user;
        if(seller.isPresent()) user = seller.get();
        else if(me.isPresent()) user = me.get();
        else throw new NotFoundException("ID de usuario invalido");
        List<Seller> userFolloweds = user.getFollowing();
        if(userFolloweds.isEmpty()) throw new NotFoundException("El usuario con id: " + user.getId() + " no sigue a vendedores");
        List<UserDTO> followed = userFolloweds.stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        return new UserFollowedDTO(user.getId(), user.getName(), ordenarUsuariosPorNombre(followed, order));
    }

    private List<UserDTO> ordenarUsuariosPorNombre (List<UserDTO> users, String order) {
        if (order.equals("name_asc")){
            users = users.stream()
                    .sorted(Comparator.comparing(UserDTO::getName))
                    .collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            users = users.stream()
                    .sorted(Comparator.comparing(UserDTO::getName, Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        }
        else if(!order.isEmpty()) throw new BadRequestException("El tipo de ordenamiento alfabetico es incorrecto");
        return users;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
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
