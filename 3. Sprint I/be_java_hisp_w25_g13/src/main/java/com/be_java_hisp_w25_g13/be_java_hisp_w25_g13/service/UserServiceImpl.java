package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IPostRepository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.WrongDataException;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IPostRepository postRepository;
    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("El vendedor no se puede seguir a si mismo");
        }

        Optional<User> optionalUser = userRepository.getUserById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }

        Optional<User> optionalUserToFollow = userRepository.getUserById(userIdToFollow);
        if (optionalUserToFollow.isEmpty()) {
            throw new NotFoundException("El id del vendedor a seguir no se encuentra registrado");
        }

        User userToFollow = optionalUserToFollow.get();
        if (!(userToFollow instanceof Seller seller)) {
            throw new BadRequestException("El id del vendedor a seguir no se encuentra registrado");
        }

        User user = optionalUser.get();

        user.getFollowing().add(seller);
        seller.getFollowers().add(user);
    }

    @Override
    public void unFollowUser(Integer userId, Integer userIdToUnfollow) {
        Optional<User> optionalUser = userRepository.getUserById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }

        Optional<User> optionalUserToFollow = userRepository.getUserById(userIdToUnfollow);
        if (optionalUserToFollow.isEmpty()) {
            throw new NotFoundException("El id del vendedor no se encuentra registrado");
        }

        User userToFollow = optionalUserToFollow.get();
        if (!(userToFollow instanceof Seller seller)) {
            throw new NotFoundException("El id del vendedor no se encuentra registrado");
        }

        User user = optionalUser.get();
        if (seller.getFollowers().stream().anyMatch(follower -> follower.equals(user))) {
            throw new BadRequestException("El usuario no sigue al vendedor con ese id");
        }

        user.getFollowing().remove(seller);
        seller.getFollowers().remove(user);
    }

    @Override
    public UserDTO addUser(UserDTO userDto) {
        return null;
    }

    @Override
    public FollowersDTO getFollowers(Integer userId, String orderBy) {
        List<User> followers = getFollowersAuxFunction(userId);
        followers = orderUserList(followers,orderBy);
        return Mapper.toFollowersDTO(userRepository.getUserById(userId).get(),followers);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return null;
    }

    @Override
    public NumberDTO getNumberOfFollowers(Integer userId) {
        Optional<User> user = userRepository.getUserById(userId);

        if(user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        if(!(user.get() instanceof Seller)){
            throw new BadRequestException("El id de este usuario no es el de un vendedor");
        }
        return new NumberDTO(user.get().getUserId(),user.get().getUserName(),((Seller) user.get()).getFollowers().size());
    }

    @Override
    public List<UserDTO> getAllUsers(){
        return userRepository.getAll().stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
    }

    @Override
    public FollowedDTO getFollowed(Integer userId, String OrderBy){
        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        User foundUser = user.get();

        List<User> followingList = orderUserList(foundUser.getFollowing().stream().map(s -> (User) s).toList(), OrderBy);

        return new FollowedDTO(
                foundUser.getUserId(),
                foundUser.getUserName(),
                followingList.stream().map(Mapper::mapUserToUserDto).toList());
    }


    @Override
    public SellerPostDTO getPostPerSeller(Integer id, String order) {
        Optional<User> user = userRepository.getUserById(id);
        if (!user.isPresent()){
            throw new NotFoundException("El usuario no ha sido encontrado");
        }
        LocalDate hourNow = LocalDate.now();
        List<Post> response = new ArrayList<>();
         user.get().getFollowing().stream().filter(x -> {
            if (postRepository.filterByDateAndIdUsuario(x.getUserId(), hourNow).isEmpty()){
                return false;
            }
            return true;
        }).forEach(x ->  postRepository.filterByDateAndIdUsuario(x.getUserId(), hourNow).forEach(y -> response.add(y)));

        if (order.equals("none")) {
            return new SellerPostDTO(id, response.stream().map(y -> Mapper.mapPostToPost2DTO(y)).toList());
        } else if (order.equals("date_asc")){
            return new SellerPostDTO(id, OrderBy.orderByDateAsc(response).stream().map(y -> Mapper.mapPostToPost2DTO(y)).toList());
        } else if (order.equals("date_desc")) {
            return new SellerPostDTO(id, OrderBy.orderByDateAsc(response).stream().map(y -> Mapper.mapPostToPost2DTO(y)).toList());
        }
        return null;

    }


    private List<User> getFollowersAuxFunction(Integer userId){
        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        if(!(user.get() instanceof Seller)){
            throw new BadRequestException("El id de este usuario no es el de un vendedor");
        }
        return ((Seller) user.get()).getFollowers();
    }
    private List<User> orderUserList(List<User> users, String orderBy){
        if(orderBy.equalsIgnoreCase("asc")){
            return OrderBy.orderByUserAsc(users);
        }
        if(orderBy.equalsIgnoreCase("desc")){
            return OrderBy.orderByUserDes(users);
        }
        return users;
    }


}
