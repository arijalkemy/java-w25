package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IPostRepository;


import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

import java.util.ArrayList;
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
            throw new BadRequestException("El usuario no se puede seguir a si mismo");
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
            throw new BadRequestException("El id del usuario no corresponde a un vendedor");
        }
        User user = optionalUser.get();
        if (seller.getFollowers().stream()
            .anyMatch(follower -> follower.getUserId().equals(user.getUserId()))) {
                throw new BadRequestException("El usuario ya sigue al vendedor con ese id");
        }
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
        User userToUnfollow = optionalUserToFollow.get();
        if (!(userToUnfollow instanceof Seller seller)) {
            throw new NotFoundException("El id del usuario no corresponde al de un vendedor");
        }
        User user = optionalUser.get();
        if (seller.getFollowers().stream()
            .noneMatch(follower -> follower.getUserId().equals(user.getUserId()))) {
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
    public NumberDTO getNumberOfFollowers(Integer userId) {
        List<User> users = getFollowersAuxFunction(userId);
        User user = userRepository.getUserById(userId).get();
        return new NumberDTO(user.getUserId(),user.getUserName(),users.size());
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

        List<User> followingList = orderUserList(foundUser.getFollowing().stream()
            .map(s -> (User) s).toList(), OrderBy);

        return new FollowedDTO(
                foundUser.getUserId(),
                foundUser.getUserName(),
                followingList.stream().map(Mapper::mapUserToUserDto).toList());
    }
    @Override
    public SellerPostDTO getPostPerSeller(Integer id, String orderBy) {
        Optional<User> user = userRepository.getUserById(id);
        if (user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        LocalDate hourNow = LocalDate.now();
        List<Post> posts = new ArrayList<>();
         user.get().getFollowing().stream()
                 .filter(x -> !(postRepository.filterByDateAndIdUsuario(x.getUserId(), hourNow).isEmpty()))
                 .forEach(x -> posts.addAll(postRepository.filterByDateAndIdUsuario(x.getUserId(), hourNow)));

        return new SellerPostDTO(id, orderPostList(posts, orderBy).stream().map(Mapper::mapPostToPost2DTO).toList());
    }
    private List<User> getFollowersAuxFunction(Integer userId){
        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        if(!(user.get() instanceof Seller)){
            throw new BadRequestException("El id del usuario no corresponde al de un vendedor");
        }
        return ((Seller) user.get()).getFollowers();
    }
    private List<Post> orderPostList(List<Post> posts, String orderBy){

        return switch (orderBy) {
            case "date_asc" -> OrderBy.orderByDateAsc(posts);
            case "date_desc" -> OrderBy.orderByDateDes(posts);
            case "none" -> posts;
            default ->
                    throw new BadRequestException(
                        "El metodo de ordenamiento debe estar entre date_asc, date_desc o no tener ninguno"
                    );
        };
    }
    private List<User> orderUserList(List<User> users, String orderBy){
        return switch (orderBy){
            case "name_asc" -> OrderBy.orderByUserAsc(users);
            case "name_desc" -> OrderBy.orderByUserDes(users);
            case "none" -> users;
            default ->
                    throw new BadRequestException(
                        "El metodo de ordenamiento debe estar entre name_asc, name_desc o no tener ninguno"
                    );
        };
    }
}
